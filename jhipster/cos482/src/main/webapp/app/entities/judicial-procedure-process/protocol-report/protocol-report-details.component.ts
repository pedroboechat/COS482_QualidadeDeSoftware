import { Component, Vue, Inject } from 'vue-property-decorator';

import ProtocolReportService from './protocol-report.service';
import { ProtocolReportContext } from './protocol-report.model';

@Component
export default class ProtocolReportDetailsComponent extends Vue {
  private protocolReportService: ProtocolReportService = new ProtocolReportService();
  private taskContext: ProtocolReportContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.protocolReportService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
