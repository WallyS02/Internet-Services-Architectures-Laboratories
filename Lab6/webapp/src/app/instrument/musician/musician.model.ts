import {IInstrument} from "../instrument.model";

export interface IMusician {
  id: string;
  name: string;
  pseudonym: string;
  instrument: Pick<IInstrument, 'id'>;
}

export interface NewAddMusician {
  id: string;
  name: string;
  pseudonym: string;
  instrument: string;
}

export type NewMusician = Omit<IMusician, 'instrument'>
