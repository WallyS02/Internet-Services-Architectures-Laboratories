import {Component, OnInit} from '@angular/core';
import {NewInstrument} from "../instrument.model";
import {ActivatedRoute, Router} from "@angular/router";
import {InstrumentService} from "../instrument-service/instrument.service";

@Component({
  selector: 'app-edit',
  templateUrl: './instrument-edit.component.html',
  styleUrls: ['./instrument-edit.component.css']
})
export class InstrumentEditComponent implements OnInit {
  instrument: NewInstrument = { id: '', name: '', type: '' } as NewInstrument
  id: string | null = '';

  constructor(
    protected route: ActivatedRoute,
    protected router: Router,
    protected instrumentService: InstrumentService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.instrumentService.find(this.id).subscribe(response => {
      this.instrument.id = <string>response.body?.id;
      this.instrument.name = <string>response.body?.name;
      this.instrument.type = <string>response.body?.type;
    });
  }

  protected confirm(): void {
    this.instrumentService.update(this.instrument).subscribe(() => {
      this.router.navigate(['/']).then(r => {});
    });
  }
}
