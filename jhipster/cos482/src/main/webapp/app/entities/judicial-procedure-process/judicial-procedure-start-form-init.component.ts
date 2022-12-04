import { Component, Vue, Inject } from 'vue-property-decorator';

import JudgeService from '@/entities/judge/judge.service'; //
import { IJudge } from '@/shared/model/judge.model';

import { IJudicialProcedureProcess, JudicialProcedureProcess } from '@/shared/model/judicial-procedure-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { JudicialProcedure } from '@/shared/model/judicial-procedure.model';
import JudicialProcedureProcessService from './judicial-procedure-process.service';

const validations: any = {
  judicialProcedureProcess: {
    judicialProcedure: {
      numeroDoProcesso: {},
      tribunal: {},
      necessitaLaudo: {},
    },
  },
};

@Component({
  validations,
})
export default class JudicialProcedureStartFormInitComponent extends Vue {
  @Inject('judicialProcedureProcessService') private judicialProcedureProcessService: () => JudicialProcedureProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'JudicialProcedure';
  public judicialProcedureProcess: IJudicialProcedureProcess = new JudicialProcedureProcess();

  @Inject('judgeService') private judgeService: () => JudgeService;

  public judges: IJudge[] = [];

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initJudicialProcedureStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.judicialProcedureProcessService()
      .create(this.judicialProcedureProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('cos482App.judicialProcedureStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initJudicialProcedureStartForm(): void {
    this.judicialProcedureProcess.judicialProcedure = new JudicialProcedure();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.judicialProcedureProcess.processInstance = new ProcessInstance();
      this.judicialProcedureProcess.processInstance.processDefinition = res;
    });
    this.judgeService()
      .retrieve()
      .then(res => {
        this.judges = res.data;
      });
  }
}
