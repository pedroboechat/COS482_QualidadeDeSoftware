<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('cos482App.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('cos482App.assignReporter.laudista')">laudista</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="laudista"
                id="judicial-procedure-laudista"
                data-cy="laudista"
                v-model="taskContext.judicialProcedureProcess.judicialProcedure.laudista"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('cos482App.assignReporter.dataDaVisita')">dataDaVisita</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="dataDaVisita"
                id="judicial-procedure-dataDaVisita"
                data-cy="dataDaVisita"
                v-model="taskContext.judicialProcedureProcess.judicialProcedure.dataDaVisita"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('cos482App.assignReporter.endereco')">endereco</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="endereco"
                id="judicial-procedure-endereco"
                data-cy="endereco"
                v-model="taskContext.judicialProcedureProcess.judicialProcedure.endereco"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/JudicialProcedure/task/AssignReporter/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./assign-reporter-details.component.ts"></script>
