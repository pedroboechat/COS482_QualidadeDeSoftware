import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IJudicialProcedure } from '@/shared/model/judicial-procedure.model';

import JudicialProcedureService from './judicial-procedure.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class JudicialProcedure extends Vue {
  @Inject('judicialProcedureService') private judicialProcedureService: () => JudicialProcedureService;
  private removeId: number = null;

  public judicialProcedures: IJudicialProcedure[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllJudicialProcedures();
  }

  public clear(): void {
    this.retrieveAllJudicialProcedures();
  }

  public retrieveAllJudicialProcedures(): void {
    this.isFetching = true;

    this.judicialProcedureService()
      .retrieve()
      .then(
        res => {
          this.judicialProcedures = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
