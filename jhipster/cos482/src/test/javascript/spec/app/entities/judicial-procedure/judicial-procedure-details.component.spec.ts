/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import JudicialProcedureDetailComponent from '@/entities/judicial-procedure/judicial-procedure-details.vue';
import JudicialProcedureClass from '@/entities/judicial-procedure/judicial-procedure-details.component';
import JudicialProcedureService from '@/entities/judicial-procedure/judicial-procedure.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('JudicialProcedure Management Detail Component', () => {
    let wrapper: Wrapper<JudicialProcedureClass>;
    let comp: JudicialProcedureClass;
    let judicialProcedureServiceStub: SinonStubbedInstance<JudicialProcedureService>;

    beforeEach(() => {
      judicialProcedureServiceStub = sinon.createStubInstance<JudicialProcedureService>(JudicialProcedureService);

      wrapper = shallowMount<JudicialProcedureClass>(JudicialProcedureDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { judicialProcedureService: () => judicialProcedureServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundJudicialProcedure = { id: 123 };
        judicialProcedureServiceStub.find.resolves(foundJudicialProcedure);

        // WHEN
        comp.retrieveJudicialProcedure(123);
        await comp.$nextTick();

        // THEN
        expect(comp.judicialProcedure).toBe(foundJudicialProcedure);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundJudicialProcedure = { id: 123 };
        judicialProcedureServiceStub.find.resolves(foundJudicialProcedure);

        // WHEN
        comp.beforeRouteEnter({ params: { judicialProcedureId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.judicialProcedure).toBe(foundJudicialProcedure);
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
