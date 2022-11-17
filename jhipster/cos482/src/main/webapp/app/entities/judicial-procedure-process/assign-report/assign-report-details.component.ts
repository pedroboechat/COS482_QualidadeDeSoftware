import { Component, Vue, Inject } from 'vue-property-decorator';

import AssignReportService from './assign-report.service';
import { AssignReportContext } from './assign-report.model';

@Component
export default class AssignReportDetailsComponent extends Vue {
  private assignReportService: AssignReportService = new AssignReportService();
  private taskContext: AssignReportContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.assignReportService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
