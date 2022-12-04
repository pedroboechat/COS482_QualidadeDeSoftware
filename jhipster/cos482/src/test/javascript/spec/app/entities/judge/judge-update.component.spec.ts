/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import * as config from '@/shared/config/config';
import JudgeUpdateComponent from '@/entities/judge/judge-update.vue';
import JudgeClass from '@/entities/judge/judge-update.component';
import JudgeService from '@/entities/judge/judge.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('Judge Management Update Component', () => {
    let wrapper: Wrapper<JudgeClass>;
    let comp: JudgeClass;
    let judgeServiceStub: SinonStubbedInstance<JudgeService>;

    beforeEach(() => {
      judgeServiceStub = sinon.createStubInstance<JudgeService>(JudgeService);

      wrapper = shallowMount<JudgeClass>(JudgeUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          judgeService: () => judgeServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.judge = entity;
        judgeServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(judgeServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.judge = entity;
        judgeServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(judgeServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundJudge = { id: 123 };
        judgeServiceStub.find.resolves(foundJudge);
        judgeServiceStub.retrieve.resolves([foundJudge]);

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
