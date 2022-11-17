import { Component, Vue, Inject } from 'vue-property-decorator';

import ProtocolReportService from './protocol-report.service';
import { ProtocolReportContext } from './protocol-report.model';

const validations: any = {
  taskContext: {
    judicialProcedureProcess: {
      judicialProcedure: {
        protocoladoEm: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class ProtocolReportExecuteComponent extends Vue {
  private protocolReportService: ProtocolReportService = new ProtocolReportService();
  private taskContext: ProtocolReportContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.protocolReportService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.protocolReportService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
