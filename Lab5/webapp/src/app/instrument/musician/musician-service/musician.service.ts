import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http"
import {Observable} from "rxjs";
import {IMusician, NewAddMusician, NewMusician} from "../musician.model";

export type EntityResponseType = HttpResponse<IMusician>;
export type EntityArrayResponseType = HttpResponse<any>;

@Injectable({
  providedIn: 'root'
})
export class MusicianService {
  protected url = "http://localhost:8080/api/musicians"
  constructor(
    protected http: HttpClient
  ) {}

  create(musician: NewAddMusician): Observable<EntityResponseType> {
    return this.http.put<IMusician>(`${this.url}/${musician.id}`, musician, { observe: 'response' });
  }

  update(musician: NewMusician): Observable<EntityResponseType> {
    return this.http.patch<IMusician>(`${this.url}/${musician.id}`, musician, { observe: 'response' });
  }

  delete(id: string): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.url}/${id}`, { observe: 'response' });
  }

  find(id: string | null): Observable<EntityResponseType> {
    return this.http.get<IMusician>(`${this.url}/${id}`, { observe: 'response' });
  }

  query(): Observable<EntityArrayResponseType> {
    return this.http.get<any>(this.url, { observe: 'response' });
  }

  queryInstrumentMusicians(instrumentId: string | undefined): Observable<EntityArrayResponseType> {
    return this.http.get<any>(`http://localhost:8080/api/instruments/${instrumentId}/musicians`, { observe: 'response' })
  }
}
