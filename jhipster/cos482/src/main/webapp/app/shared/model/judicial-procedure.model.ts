export interface IJudicialProcedure {
  id?: number;
  NumeroDoProcesso?: string | null;
  Tribunal?: string | null;
  Juiz?: string | null;
  NecessitaLaudo?: boolean | null;
  Laudista?: string | null;
  DataDaVisita?: Date | null;
  Endereco?: string | null;
  LinkLaudo?: string | null;
  LaudoValido?: boolean | null;
  ProtocoladoEm?: Date | null;
}

export class JudicialProcedure implements IJudicialProcedure {
  constructor(
    public id?: number,
    public NumeroDoProcesso?: string | null,
    public Tribunal?: string | null,
    public Juiz?: string | null,
    public NecessitaLaudo?: boolean | null,
    public Laudista?: string | null,
    public DataDaVisita?: Date | null,
    public Endereco?: string | null,
    public LinkLaudo?: string | null,
    public LaudoValido?: boolean | null,
    public ProtocoladoEm?: Date | null
  ) {
    this.NecessitaLaudo = this.NecessitaLaudo ?? false;
    this.LaudoValido = this.LaudoValido ?? false;
  }
}
