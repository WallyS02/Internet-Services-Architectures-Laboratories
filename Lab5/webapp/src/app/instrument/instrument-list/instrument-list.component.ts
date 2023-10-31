import {Component, OnInit} from '@angular/core';
import {IInstrument} from "../instrument.model";
import {InstrumentService} from "../instrument-service/instrument.service";

@Component({
  selector: 'app-list',
  templateUrl: './instrument-list.component.html',
  styleUrls: ['./instrument-list.component.css']
})
export class InstrumentListComponent implements OnInit {
  instruments: IInstrument[] | null = [];

  constructor(
    protected instrumentService: InstrumentService
  ) {}

  ngOnInit(): void {
    this.instrumentService.query().subscribe(response => {
      this.instruments = response.body.instruments;
    });
  }

  protected delete(id: string): void {
    this.instrumentService.delete(id).subscribe(() => {
      this.ngOnInit();
    });
  }
}
