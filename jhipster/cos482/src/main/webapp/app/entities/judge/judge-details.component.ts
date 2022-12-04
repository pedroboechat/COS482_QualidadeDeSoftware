import { Component, Vue, Inject } from 'vue-property-decorator';

import { IJudge } from '@/shared/model/judge.model';
import JudgeService from './judge.service';

@Component
export default class JudgeDetails extends Vue {
  @Inject('judgeService') private judgeService: () => JudgeService;
  public judge: IJudge = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.judgeId) {
        vm.retrieveJudge(to.params.judgeId);
      }
    });
  }

  public retrieveJudge(judgeId) {
    this.judgeService()
      .find(judgeId)
      .then(res => {
        this.judge = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
