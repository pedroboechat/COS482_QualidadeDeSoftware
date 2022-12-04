/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import JudgeComponent from '@/entities/judge/judge.vue';
import JudgeClass from '@/entities/judge/judge.component';
import JudgeService from '@/entities/judge/judge.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Judge Management Component', () => {
    let wrapper: Wrapper<JudgeClass>;
    let comp: JudgeClass;
    let judgeServiceStub: SinonStubbedInstance<JudgeService>;

    beforeEach(() => {
      judgeServiceStub = sinon.createStubInstance<JudgeService>(JudgeService);
      judgeServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<JudgeClass>(JudgeComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          judgeService: () => judgeServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      judgeServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllJudges();
      await comp.$nextTick();

      // THEN
      expect(judgeServiceStub.retrieve.called).toBeTruthy();
      expect(comp.judges[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      judgeServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeJudge();
      await comp.$nextTick();

      // THEN
      expect(judgeServiceStub.delete.called).toBeTruthy();
      expect(judgeServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
