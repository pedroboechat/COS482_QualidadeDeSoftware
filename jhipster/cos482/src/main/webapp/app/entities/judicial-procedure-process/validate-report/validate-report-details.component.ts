import { Component, Vue, Inject } from 'vue-property-decorator';

import ValidateReportService from './validate-report.service';
import { ValidateReportContext } from './validate-report.model';

@Component
export default class ValidateReportDetailsComponent extends Vue {
  private validateReportService: ValidateReportService = new ValidateReportService();
  private taskContext: ValidateReportContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.validateReportService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
