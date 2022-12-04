/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import JudgeDetailComponent from '@/entities/judge/judge-details.vue';
import JudgeClass from '@/entities/judge/judge-details.component';
import JudgeService from '@/entities/judge/judge.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Judge Management Detail Component', () => {
    let wrapper: Wrapper<JudgeClass>;
    let comp: JudgeClass;
    let judgeServiceStub: SinonStubbedInstance<JudgeService>;

    beforeEach(() => {
      judgeServiceStub = sinon.createStubInstance<JudgeService>(JudgeService);

      wrapper = shallowMount<JudgeClass>(JudgeDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { judgeService: () => judgeServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundJudge = { id: 123 };
        judgeServiceStub.find.resolves(foundJudge);

        // WHEN
        comp.retrieveJudge(123);
        await comp.$nextTick();

        // THEN
        expect(comp.judge).toBe(foundJudge);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundJudge = { id: 123 };
        judgeServiceStub.find.resolves(foundJudge);

        // WHEN
        comp.beforeRouteEnter({ params: { judgeId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.judge).toBe(foundJudge);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
