import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {IInstrument, NewInstrument} from "../instrument.model";
import {Observable} from "rxjs";

export type EntityResponseType = HttpResponse<IInstrument>;
export type EntityArrayResponseType = HttpResponse<any>;

@Injectable({
  providedIn: 'root'
})
export class InstrumentService {
  protected url = "http://localhost:8080/api/instruments"

  constructor(
    protected http: HttpClient
  ) {}

  create(instrument: NewInstrument | undefined): Observable<EntityResponseType> {
    return this.http.put<IInstrument>(`${this.url}/${instrument!.id}`, instrument, { observe: 'response' });
  }

  update(instrument: NewInstrument): Observable<EntityResponseType> {
    return this.http.patch<IInstrument>(`${this.url}/${instrument.id}`, instrument, { observe: 'response' });
  }

  delete(id: string): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.url}/${id}`, { observe: 'response' });
  }

  find(id: string | undefined | null): Observable<EntityResponseType> {
    return this.http.get<IInstrument>(`${this.url}/${id}`, { observe: 'response' });
  }

  query(): Observable<EntityArrayResponseType> {
    return this.http.get<any>(this.url, { observe: 'response' });
  }
}
