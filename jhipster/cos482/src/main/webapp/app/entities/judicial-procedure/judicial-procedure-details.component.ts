import { Component, Vue, Inject } from 'vue-property-decorator';

import { IJudicialProcedure } from '@/shared/model/judicial-procedure.model';
import JudicialProcedureService from './judicial-procedure.service';

@Component
export default class JudicialProcedureDetails extends Vue {
  @Inject('judicialProcedureService') private judicialProcedureService: () => JudicialProcedureService;
  public judicialProcedure: IJudicialProcedure = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.judicialProcedureId) {
        vm.retrieveJudicialProcedure(to.params.judicialProcedureId);
      }
    });
  }

  public retrieveJudicialProcedure(judicialProcedureId) {
    this.judicialProcedureService()
      .find(judicialProcedureId)
      .then(res => {
        this.judicialProcedure = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
