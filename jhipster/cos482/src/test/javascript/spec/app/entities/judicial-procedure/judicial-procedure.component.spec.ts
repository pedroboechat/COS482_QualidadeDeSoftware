/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import JudicialProcedureComponent from '@/entities/judicial-procedure/judicial-procedure.vue';
import JudicialProcedureClass from '@/entities/judicial-procedure/judicial-procedure.component';
import JudicialProcedureService from '@/entities/judicial-procedure/judicial-procedure.service';

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
  describe('JudicialProcedure Management Component', () => {
    let wrapper: Wrapper<JudicialProcedureClass>;
    let comp: JudicialProcedureClass;
    let judicialProcedureServiceStub: SinonStubbedInstance<JudicialProcedureService>;

    beforeEach(() => {
      judicialProcedureServiceStub = sinon.createStubInstance<JudicialProcedureService>(JudicialProcedureService);
      judicialProcedureServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<JudicialProcedureClass>(JudicialProcedureComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          judicialProcedureService: () => judicialProcedureServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      judicialProcedureServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllJudicialProcedures();
      await comp.$nextTick();

      // THEN
      expect(judicialProcedureServiceStub.retrieve.called).toBeTruthy();
      expect(comp.judicialProcedures[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
