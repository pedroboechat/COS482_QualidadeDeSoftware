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
// prettier-ignore
const JudicialProcedureProcess_ValidateReportDetails = () => import('@/entities/judicial-procedure-process/validate-report/validate-report-details.vue');
// prettier-ignore
const JudicialProcedureProcess_ValidateReportExecute = () => import('@/entities/judicial-procedure-process/validate-report/validate-report-execute.vue');
// prettier-ignore
const JudicialProcedureProcess_AssignReportDetails = () => import('@/entities/judicial-procedure-process/assign-report/assign-report-details.vue');
// prettier-ignore
const JudicialProcedureProcess_AssignReportExecute = () => import('@/entities/judicial-procedure-process/assign-report/assign-report-execute.vue');
// prettier-ignore
const JudicialProcedureProcess_AssignReporterDetails = () => import('@/entities/judicial-procedure-process/assign-reporter/assign-reporter-details.vue');
// prettier-ignore
const JudicialProcedureProcess_AssignReporterExecute = () => import('@/entities/judicial-procedure-process/assign-reporter/assign-reporter-execute.vue');
// prettier-ignore
const JudicialProcedureProcess_ProtocolReportDetails = () => import('@/entities/judicial-procedure-process/protocol-report/protocol-report-details.vue');
// prettier-ignore
const JudicialProcedureProcess_ProtocolReportExecute = () => import('@/entities/judicial-procedure-process/protocol-report/protocol-report-execute.vue');
// prettier-ignore
const Judge = () => import('@/entities/judge/judge.vue');
// prettier-ignore
const JudgeUpdate = () => import('@/entities/judge/judge-update.vue');
// prettier-ignore
const JudgeDetails = () => import('@/entities/judge/judge-details.vue');
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
  {
    path: '/process-definition/JudicialProcedure/task/ValidateReport/:taskInstanceId/view',
    name: 'JudicialProcedureProcess_ValidateReportDetails',
    component: JudicialProcedureProcess_ValidateReportDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/task/ValidateReport/:taskInstanceId/execute',
    name: 'JudicialProcedureProcess_ValidateReportExecute',
    component: JudicialProcedureProcess_ValidateReportExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/task/AssignReport/:taskInstanceId/view',
    name: 'JudicialProcedureProcess_AssignReportDetails',
    component: JudicialProcedureProcess_AssignReportDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/task/AssignReport/:taskInstanceId/execute',
    name: 'JudicialProcedureProcess_AssignReportExecute',
    component: JudicialProcedureProcess_AssignReportExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/task/AssignReporter/:taskInstanceId/view',
    name: 'JudicialProcedureProcess_AssignReporterDetails',
    component: JudicialProcedureProcess_AssignReporterDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/task/AssignReporter/:taskInstanceId/execute',
    name: 'JudicialProcedureProcess_AssignReporterExecute',
    component: JudicialProcedureProcess_AssignReporterExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/task/ProtocolReport/:taskInstanceId/view',
    name: 'JudicialProcedureProcess_ProtocolReportDetails',
    component: JudicialProcedureProcess_ProtocolReportDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/JudicialProcedure/task/ProtocolReport/:taskInstanceId/execute',
    name: 'JudicialProcedureProcess_ProtocolReportExecute',
    component: JudicialProcedureProcess_ProtocolReportExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/judge',
    name: 'Judge',
    component: Judge,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/judge/new',
    name: 'JudgeCreate',
    component: JudgeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/judge/:judgeId/edit',
    name: 'JudgeEdit',
    component: JudgeUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/judge/:judgeId/view',
    name: 'JudgeView',
    component: JudgeDetails,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
