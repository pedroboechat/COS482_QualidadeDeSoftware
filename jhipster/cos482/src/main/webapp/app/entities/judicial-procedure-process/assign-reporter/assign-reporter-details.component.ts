import { Component, Vue, Inject } from 'vue-property-decorator';

import AssignReporterService from './assign-reporter.service';
import { AssignReporterContext } from './assign-reporter.model';

@Component
export default class AssignReporterDetailsComponent extends Vue {
  private assignReporterService: AssignReporterService = new AssignReporterService();
  private taskContext: AssignReporterContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.assignReporterService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
