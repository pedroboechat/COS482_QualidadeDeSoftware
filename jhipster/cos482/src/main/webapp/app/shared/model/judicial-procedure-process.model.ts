import { IJudicialProcedure } from '@/shared/model/judicial-procedure.model';

export interface IJudicialProcedureProcess {
  id?: number;
  processInstance?: any | null;
  judicialProcedure?: IJudicialProcedure | null;
}

export class JudicialProcedureProcess implements IJudicialProcedureProcess {
  constructor(public id?: number, public processInstance?: any | null, public judicialProcedure?: IJudicialProcedure | null) {}
}
