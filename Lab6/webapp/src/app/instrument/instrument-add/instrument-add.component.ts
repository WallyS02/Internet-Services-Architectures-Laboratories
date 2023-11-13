import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {InstrumentService} from "../instrument-service/instrument.service";
import {NewInstrument} from "../instrument.model";

@Component({
  selector: 'app-add',
  templateUrl: './instrument-add.component.html',
  styleUrls: ['./instrument-add.component.css']
})
export class InstrumentAddComponent {
  instrument: NewInstrument = { id: '', name: '', type: '' } as NewInstrument

  constructor(
    protected router: Router,
    protected instrumentService: InstrumentService
  ) {}

  protected confirm(): void {
    this.instrumentService.create(this.instrument).subscribe(() => {
      this.router.navigate(['/']).then(r => {});
    });
  }
}
