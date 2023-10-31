import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import {InstrumentListComponent} from "./instrument/instrument-list/instrument-list.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {MatListModule} from "@angular/material/list";
import {MatButtonModule} from "@angular/material/button";
import {RouterLink} from "@angular/router";
import {InstrumentAddComponent} from "./instrument/instrument-add/instrument-add.component";
import {MatInputModule} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {InstrumentEditComponent} from "./instrument/instrument-edit/instrument-edit.component";
import {InstrumentDetailComponent} from "./instrument/instrument-detail/instrument-detail.component";
import { AppComponent } from './app.component';
import {MusicianAddComponent} from "./instrument/musician/musician-add/musician-add.component";
import {MusicianEditComponent} from "./instrument/musician/musician-edit/musician-edit.component";
import {MusicianDetailComponent} from "./instrument/musician/musician-detail/musician-detail.component";

@NgModule({
  declarations: [AppComponent, InstrumentListComponent, InstrumentAddComponent, InstrumentEditComponent, InstrumentDetailComponent, MusicianAddComponent, MusicianEditComponent, MusicianDetailComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    CommonModule,
    MatListModule,
    MatButtonModule,
    HttpClientModule,
    MatInputModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
