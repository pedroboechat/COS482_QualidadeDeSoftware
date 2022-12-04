import { IJudge } from '@/shared/model/judge.model';

export interface IJudicialProcedure {
  id?: number;
  numeroDoProcesso?: string | null;
  tribunal?: string | null;
  necessitaLaudo?: boolean | null;
  laudista?: string | null;
  dataDaVisita?: Date | null;
  endereco?: string | null;
  linkLaudo?: string | null;
  laudoValido?: boolean | null;
  protocoladoEm?: Date | null;
  judge?: IJudge | null;
}

export class JudicialProcedure implements IJudicialProcedure {
  constructor(
    public id?: number,
    public numeroDoProcesso?: string | null,
    public tribunal?: string | null,
    public necessitaLaudo?: boolean | null,
    public laudista?: string | null,
    public dataDaVisita?: Date | null,
    public endereco?: string | null,
    public linkLaudo?: string | null,
    public laudoValido?: boolean | null,
    public protocoladoEm?: Date | null,
    public judge?: IJudge | null
  ) {
    this.necessitaLaudo = this.necessitaLaudo ?? false;
    this.laudoValido = this.laudoValido ?? false;
  }
}
