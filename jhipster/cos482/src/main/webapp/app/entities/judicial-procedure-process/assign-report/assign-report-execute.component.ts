import { Component, Vue, Inject } from 'vue-property-decorator';

import AssignReportService from './assign-report.service';
import { AssignReportContext } from './assign-report.model';

const validations: any = {
  taskContext: {
    judicialProcedureProcess: {
      judicialProcedure: {
        linkLaudo: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class AssignReportExecuteComponent extends Vue {
  private assignReportService: AssignReportService = new AssignReportService();
  private taskContext: AssignReportContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.assignReportService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.assignReportService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
