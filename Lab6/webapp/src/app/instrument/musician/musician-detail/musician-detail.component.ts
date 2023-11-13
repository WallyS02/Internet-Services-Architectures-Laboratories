import {Component, OnInit} from '@angular/core';
import {IInstrument} from "../../instrument.model";
import {IMusician} from "../musician.model";
import {ActivatedRoute, Router} from "@angular/router";
import {InstrumentService} from "../../instrument-service/instrument.service";
import {MusicianService} from "../musician-service/musician.service";

@Component({
  selector: 'app-detail-musician',
  templateUrl: './musician-detail.component.html',
  styleUrls: ['./musician-detail.component.css']
})
export class MusicianDetailComponent implements OnInit {
  instrument: IInstrument | null = null;
  musician: IMusician | null = null;

  constructor(
    protected route: ActivatedRoute,
    protected router: Router,
    protected instrumentService: InstrumentService,
    protected musicianService: MusicianService
  ) {}

  ngOnInit(): void {
    this.musicianService.find(this.route.snapshot.paramMap.get('musician-id')).subscribe(response => {
      this.musician = response.body;
      this.instrumentService.find(this.musician?.instrument.id).subscribe(response => {
        this.instrument = response.body;
      });
    });
  }
}
