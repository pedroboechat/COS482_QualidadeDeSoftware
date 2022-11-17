<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('cos482App.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('cos482App.protocolReport.protocoladoEm')" for="protocol-report-protocoladoEm"
                >Protocolado Em</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="protocol-report-protocoladoEm"
                    v-model="$v.taskContext.judicialProcedureProcess.judicialProcedure.protocoladoEm.$model"
                    name="protocoladoEm"
                    class="form-control"
                    :locale="currentLanguage"
                    button-only
                    today-button
                    reset-button
                    close-button
                  >
                  </b-form-datepicker>
                </b-input-group-prepend>

                <b-form-input
                  id="protocol-report-protocoladoEm"
                  data-cy="protocoladoEm"
                  type="text"
                  class="form-control"
                  name="protocoladoEm"
                  :class="{
                    valid: !$v.taskContext.judicialProcedureProcess.judicialProcedure.protocoladoEm.$invalid,
                    invalid: $v.taskContext.judicialProcedureProcess.judicialProcedure.protocoladoEm.$invalid,
                  }"
                  v-model="$v.taskContext.judicialProcedureProcess.judicialProcedure.protocoladoEm.$model"
                />
              </b-input-group>
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./protocol-report-execute.component.ts"></script>
