import { Component, Vue, Inject } from 'vue-property-decorator';

import ValidateReportService from './validate-report.service';
import { ValidateReportContext } from './validate-report.model';

const validations: any = {
  taskContext: {
    judicialProcedureProcess: {
      judicialProcedure: {
        laudoValido: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class ValidateReportExecuteComponent extends Vue {
  private validateReportService: ValidateReportService = new ValidateReportService();
  private taskContext: ValidateReportContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.validateReportService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.validateReportService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
