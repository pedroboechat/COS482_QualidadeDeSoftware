import { Component, Vue, Inject } from 'vue-property-decorator';

import { IJudge, Judge } from '@/shared/model/judge.model';
import JudgeService from './judge.service';

const validations: any = {
  judge: {
    name: {},
    cpf: {},
    oab: {},
  },
};

@Component({
  validations,
})
export default class JudgeUpdate extends Vue {
  @Inject('judgeService') private judgeService: () => JudgeService;
  public judge: IJudge = new Judge();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.judgeId) {
        vm.retrieveJudge(to.params.judgeId);
      }
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
    if (this.judge.id) {
      this.judgeService()
        .update(this.judge)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('cos482App.judge.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.judgeService()
        .create(this.judge)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('cos482App.judge.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    }
  }

  public retrieveJudge(judgeId): void {
    this.judgeService()
      .find(judgeId)
      .then(res => {
        this.judge = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
