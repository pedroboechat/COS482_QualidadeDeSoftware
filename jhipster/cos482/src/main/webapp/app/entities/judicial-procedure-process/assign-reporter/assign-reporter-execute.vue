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
              <label class="form-control-label" v-text="$t('cos482App.assignReporter.laudista')" for="assign-reporter-laudista"
                >Laudista</label
              >
              <input
                type="text"
                class="form-control"
                name="laudista"
                id="assign-reporter-laudista"
                data-cy="laudista"
                :class="{
                  valid: !$v.taskContext.judicialProcedureProcess.judicialProcedure.laudista.$invalid,
                  invalid: $v.taskContext.judicialProcedureProcess.judicialProcedure.laudista.$invalid,
                }"
                v-model="$v.taskContext.judicialProcedureProcess.judicialProcedure.laudista.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('cos482App.assignReporter.dataDaVisita')" for="assign-reporter-dataDaVisita"
                >Data Da Visita</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="assign-reporter-dataDaVisita"
                    v-model="$v.taskContext.judicialProcedureProcess.judicialProcedure.dataDaVisita.$model"
                    name="dataDaVisita"
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
                  id="assign-reporter-dataDaVisita"
                  data-cy="dataDaVisita"
                  type="text"
                  class="form-control"
                  name="dataDaVisita"
                  :class="{
                    valid: !$v.taskContext.judicialProcedureProcess.judicialProcedure.dataDaVisita.$invalid,
                    invalid: $v.taskContext.judicialProcedureProcess.judicialProcedure.dataDaVisita.$invalid,
                  }"
                  v-model="$v.taskContext.judicialProcedureProcess.judicialProcedure.dataDaVisita.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('cos482App.assignReporter.endereco')" for="assign-reporter-endereco"
                >Endereco</label
              >
              <input
                type="text"
                class="form-control"
                name="endereco"
                id="assign-reporter-endereco"
                data-cy="endereco"
                :class="{
                  valid: !$v.taskContext.judicialProcedureProcess.judicialProcedure.endereco.$invalid,
                  invalid: $v.taskContext.judicialProcedureProcess.judicialProcedure.endereco.$invalid,
                }"
                v-model="$v.taskContext.judicialProcedureProcess.judicialProcedure.endereco.$model"
              />
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

<script lang="ts" src="./assign-reporter-execute.component.ts"></script>
