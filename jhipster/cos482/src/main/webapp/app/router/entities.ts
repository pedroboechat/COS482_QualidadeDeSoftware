import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const JudicialProcedureStartFormInit = () => import('@/entities/judicial-procedure-process/judicial-procedure-start-form-init.vue');
// prettier-ignore
const JudicialProcedure = () => import('@/entities/judicial-procedure/judicial-procedure.vue');
// prettier-ignore
const JudicialProcedureDetails = () => import('@/entities/judicial-procedure/judicial-procedure-details.vue');
// prettier-ignore
const JudicialProcedureProcessDetails = () => import('@/entities/judicial-procedure-process/judicial-procedure-process-details.vue');
// prettier-ignore
const JudicialProcedureProcessList = () => import('@/entities/judicial-procedure-process/judicial-procedure-process-list.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/process-definition/JudicialProcedureProcess/init',
    name: 'JudicialProcedureStartFormInit',
    component: JudicialProcedureStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/judicial-procedure',
    name: 'JudicialProcedure',
    component: JudicialProcedure,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/judicial-procedure/:judicialProcedureId/view',
    name: 'JudicialProcedureView',
    component: JudicialProcedureDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedureProcess/instance/:processInstanceId/view',
    name: 'JudicialProcedureProcessView',
    component: JudicialProcedureProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedureProcess/instances',
    name: 'JudicialProcedureProcessList',
    component: JudicialProcedureProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/instance/:processInstanceId/view',
    name: 'JudicialProcedureProcessView',
    component: JudicialProcedureProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/instances',
    name: 'JudicialProcedureProcessList',
    component: JudicialProcedureProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/init',
    name: 'JudicialProcedureStartFormInit',
    component: JudicialProcedureStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
