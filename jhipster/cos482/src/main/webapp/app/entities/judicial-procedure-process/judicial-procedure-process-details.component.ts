import { Component, Vue, Inject } from 'vue-property-decorator';

import { IJudicialProcedureProcess } from '@/shared/model/judicial-procedure-process.model';
import JudicialProcedureProcessService from './judicial-procedure-process.service';

@Component
export default class JudicialProcedureProcessDetailsComponent extends Vue {
  @Inject('judicialProcedureProcessService') private judicialProcedureProcessService: () => JudicialProcedureProcessService;
  public judicialProcedureProcess: IJudicialProcedureProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveJudicialProcedureProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveJudicialProcedureProcess(judicialProcedureProcessId) {
    this.isFetching = true;
    this.judicialProcedureProcessService()
      .find(judicialProcedureProcessId)
      .then(
        res => {
          this.judicialProcedureProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
