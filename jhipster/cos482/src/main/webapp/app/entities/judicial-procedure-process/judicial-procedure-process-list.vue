<template>
  <div>
    <h2 class="jh-entity-heading" data-cy="judicialProcedureProcessDetailsHeading">
      <span v-text="$t('cos482App.judicialProcedureProcess.home.title')">JudicialProcedureProcess</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('cos482App.judicialProcedureProcess.home.refreshListLabel')">Refresh List</span>
        </button>

        <router-link :to="`/process-definition/JudicialProcedure/init`" tag="button" class="btn btn-primary mr-2">
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('cos482App.judicialProcedureProcess.home.createLabel')"> Create a new Travel Plan Process Instance </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && judicialProcedureProcessList && judicialProcedureProcessList.length === 0">
      <span v-text="$t('cos482App.judicialProcedureProcess.home.notFound')">No judicialProcedureProcess found</span>
    </div>
    <div class="table-responsive" v-if="judicialProcedureProcessList && judicialProcedureProcessList.length > 0">
      <table class="table table-striped" aria-describedby="judicialProcedureProcessList">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span>Process Instance</span></th>
            <th scope="row"><span>Judicial Procedure</span></th>
            <th scope="row"><span>Status</span></th>
            <th scope="row"><span>Start Date</span></th>
            <th scope="row"><span>End Date</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="judicialProcedureProcess in judicialProcedureProcessList" :key="judicialProcedureProcess.id" data-cy="entityTable">
            <td>{{ judicialProcedureProcess.id }}</td>
            <td>
              <div v-if="judicialProcedureProcess.processInstance">
                <router-link :to="`/process-definition/JudicialProcedure/instance/${judicialProcedureProcess.processInstance.id}/view`">
                  {{ judicialProcedureProcess.processInstance.businessKey }}
                </router-link>
              </div>
            </td>
            <td>
              <div v-if="judicialProcedureProcess.judicialProcedure">
                <router-link
                  :to="{ name: 'JudicialProcedureView', params: { judicialProcedureId: judicialProcedureProcess.judicialProcedure.id } }"
                  >{{ judicialProcedureProcess.judicialProcedure.id }}</router-link
                >
              </div>
            </td>
            <td>
              <akip-show-process-instance-status
                :status="judicialProcedureProcess.processInstance.status"
              ></akip-show-process-instance-status>
            </td>
            <td>
              {{
                judicialProcedureProcess.processInstance.startDate
                  ? $d(Date.parse(judicialProcedureProcess.processInstance.startDate), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                judicialProcedureProcess.processInstance.endDate
                  ? $d(Date.parse(judicialProcedureProcess.processInstance.endDate), 'short')
                  : ''
              }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="`/process-definition/JudicialProcedure/instance/${judicialProcedureProcess.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
      <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
    </button>
  </div>
</template>

<script lang="ts" src="./judicial-procedure-process-list.component.ts"></script>
