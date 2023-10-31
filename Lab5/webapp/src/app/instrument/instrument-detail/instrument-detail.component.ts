import {Component, OnInit} from '@angular/core';
import {IInstrument} from "../instrument.model";
import {ActivatedRoute, Router} from "@angular/router";
import {InstrumentService} from "../instrument-service/instrument.service";
import {MusicianService} from "../musician/musician-service/musician.service";
import {IMusician} from "../musician/musician.model";

@Component({
  selector: 'app-detail',
  templateUrl: './instrument-detail.component.html',
  styleUrls: ['./instrument-detail.component.css']
})
export class InstrumentDetailComponent implements OnInit {
  instrument: IInstrument | null = null;
  musicians: IMusician[] | null = null;
  id: string | undefined | null;

  constructor(
    protected route: ActivatedRoute,
    protected router: Router,
    protected instrumentService: InstrumentService,
    protected musicianService: MusicianService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.instrumentService.find(this.id).subscribe(response => {
      this.instrument = response.body;
      this.musicianService.queryInstrumentMusicians(this.instrument?.id).subscribe(response => {
        this.musicians = response.body.musicians;
      });
    });
  }

  protected delete(id: string): void {
    this.musicianService.delete(id).subscribe(() => {
      this.ngOnInit();
    });
  }
}
