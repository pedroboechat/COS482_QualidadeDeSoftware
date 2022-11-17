import { Component, Vue, Inject } from 'vue-property-decorator';

import AssignReporterService from './assign-reporter.service';
import { AssignReporterContext } from './assign-reporter.model';

const validations: any = {
  taskContext: {
    judicialProcedureProcess: {
      judicialProcedure: {
        laudista: {},
        dataDaVisita: {},
        endereco: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class AssignReporterExecuteComponent extends Vue {
  private assignReporterService: AssignReporterService = new AssignReporterService();
  private taskContext: AssignReporterContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.assignReporterService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.assignReporterService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
