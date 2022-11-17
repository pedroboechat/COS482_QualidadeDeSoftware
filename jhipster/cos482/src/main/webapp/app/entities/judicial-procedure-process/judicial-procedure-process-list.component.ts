import { Component, Vue, Inject } from 'vue-property-decorator';
import { IJudicialProcedureProcess } from '@/shared/model/judicial-procedure-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import JudicialProcedureProcessService from './judicial-procedure-process.service';

@Component
export default class JudicialProcedureProcessListComponent extends Vue {
  @Inject('judicialProcedureProcessService') private judicialProcedureProcessService: () => JudicialProcedureProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'JudicialProcedure';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public judicialProcedureProcessList: IJudicialProcedureProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.judicialProcedureProcessService()
      .retrieve()
      .then(
        res => {
          this.judicialProcedureProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
