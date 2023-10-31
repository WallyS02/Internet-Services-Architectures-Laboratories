import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MusicianService} from "../musician-service/musician.service";
import {IMusician, NewAddMusician} from "../musician.model";
import {IInstrument} from "../../instrument.model";

@Component({
  selector: 'app-add-musician',
  templateUrl: './musician-add.component.html',
  styleUrls: ['./musician-add.component.css']
})
export class MusicianAddComponent {
  musician: NewAddMusician = {id: '', name: '', pseudonym: '', instrument: ''} as NewAddMusician

  constructor(
    protected route: ActivatedRoute,
    protected router: Router,
    protected musicianService: MusicianService
  ) {}

  protected confirm(): void {
    this.route.parent?.params.subscribe(params => {
      this.musician.instrument = params['id'];
      this.musicianService.create(this.musician).subscribe(() => {
        this.router.navigate(['../']).then(() => {});
      });
    });
  }
}
