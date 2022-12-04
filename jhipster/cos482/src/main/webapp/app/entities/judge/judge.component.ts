import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IJudge } from '@/shared/model/judge.model';

import JudgeService from './judge.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Judge extends Vue {
  @Inject('judgeService') private judgeService: () => JudgeService;
  private removeId: number = null;

  public judges: IJudge[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllJudges();
  }

  public clear(): void {
    this.retrieveAllJudges();
  }

  public retrieveAllJudges(): void {
    this.isFetching = true;

    this.judgeService()
      .retrieve()
      .then(
        res => {
          this.judges = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IJudge): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeJudge(): void {
    this.judgeService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('cos482App.judge.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllJudges();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
