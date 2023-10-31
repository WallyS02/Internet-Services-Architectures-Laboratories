import {IMusician} from "./musician/musician.model";

export interface IInstrument {
  id: string;
  name: string;
  type: string;
  musicians: Pick<IMusician, 'id'>[];
}

export type NewInstrument = Omit<IInstrument, 'musicians'>;
