import {Component, OnInit} from '@angular/core';
import {NewMusician} from "../musician.model";
import {ActivatedRoute, Router} from "@angular/router";
import {MusicianService} from "../musician-service/musician.service";

@Component({
  selector: 'app-edit-musician',
  templateUrl: './musician-edit.component.html',
  styleUrls: ['./musician-edit.component.css']
})
export class MusicianEditComponent implements OnInit {
  musician: NewMusician = { id: '', name: '', pseudonym: '' } as NewMusician
  id: string | null = '';
  instrumentId: string | null = '';

  constructor(
    protected route: ActivatedRoute,
    protected router: Router,
    protected musicianService: MusicianService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('musician-id');
    this.musicianService.find(this.id).subscribe(response => {
      this.musician.id = <string>response.body?.id;
      this.musician.name = <string>response.body?.name;
      this.musician.pseudonym = <string>response.body?.pseudonym;
      this.instrumentId = <string>response.body?.instrument.id;
    });
  }

  protected confirm(): void {
    this.musicianService.update(this.musician).subscribe(() => {
      this.router.navigate(['/detail', this.instrumentId]).then(r => {});
    });
  }
}
