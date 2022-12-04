export interface IJudge {
  id?: number;
  name?: string | null;
  cpf?: string | null;
  oab?: string | null;
}

export class Judge implements IJudge {
  constructor(public id?: number, public name?: string | null, public cpf?: string | null, public oab?: string | null) {}
}
