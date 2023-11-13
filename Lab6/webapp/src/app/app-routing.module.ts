import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {InstrumentAddComponent} from "./instrument/instrument-add/instrument-add.component";
import {InstrumentEditComponent} from "./instrument/instrument-edit/instrument-edit.component";
import {InstrumentDetailComponent} from "./instrument/instrument-detail/instrument-detail.component";
import {InstrumentListComponent} from "./instrument/instrument-list/instrument-list.component";
import {MusicianAddComponent} from "./instrument/musician/musician-add/musician-add.component";
import {MusicianDetailComponent} from "./instrument/musician/musician-detail/musician-detail.component";
import {MusicianEditComponent} from "./instrument/musician/musician-edit/musician-edit.component";

@NgModule({
  imports: [RouterModule.forRoot(
    [
      {
        path: '',
        component: InstrumentListComponent
      },
      {
        path: 'add',
        component: InstrumentAddComponent
      },
      {
        path: 'edit/:id',
        component: InstrumentEditComponent
      },
      {
        path: 'detail/:id',
        component: InstrumentDetailComponent,
        children: [
          {
            path: 'add-musician',
            component: MusicianAddComponent
          },
          {
            path: 'detail-musician/:musician-id',
            component: MusicianDetailComponent
          },
          {
            path: 'edit-musician/:musician-id',
            component: MusicianEditComponent
          }
        ]
      }
    ]
  )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
