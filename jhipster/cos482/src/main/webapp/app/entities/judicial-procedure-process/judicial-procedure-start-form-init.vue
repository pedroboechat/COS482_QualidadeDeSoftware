<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="cos482App.judicialProcedureStartForm.home.createOrEditLabel"
          data-cy="JudicialProcedureStartFormCreateUpdateHeading"
          v-text="$t('cos482App.judicialProcedureStartForm.home.createOrEditLabel')"
        >
          Create or edit a JudicialProcedureStartForm
        </h2>
        <div v-if="judicialProcedureProcess.processInstance">
          <akip-show-process-definition :processDefinition="judicialProcedureProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="judicialProcedureProcess.judicialProcedure">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureStartForm.numeroDoProcesso')"
                    for="judicial-procedure-start-form-numeroDoProcesso"
                    >Numero Do Processo</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="numeroDoProcesso"
                    id="judicial-procedure-start-form-numeroDoProcesso"
                    data-cy="numeroDoProcesso"
                    :class="{
                      valid: !$v.judicialProcedureProcess.judicialProcedure.numeroDoProcesso.$invalid,
                      invalid: $v.judicialProcedureProcess.judicialProcedure.numeroDoProcesso.$invalid,
                    }"
                    v-model="$v.judicialProcedureProcess.judicialProcedure.numeroDoProcesso.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureStartForm.tribunal')"
                    for="judicial-procedure-start-form-tribunal"
                    >Tribunal</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="tribunal"
                    id="judicial-procedure-start-form-tribunal"
                    data-cy="tribunal"
                    :class="{
                      valid: !$v.judicialProcedureProcess.judicialProcedure.tribunal.$invalid,
                      invalid: $v.judicialProcedureProcess.judicialProcedure.tribunal.$invalid,
                    }"
                    v-model="$v.judicialProcedureProcess.judicialProcedure.tribunal.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureStartForm.necessitaLaudo')"
                    for="judicial-procedure-start-form-necessitaLaudo"
                    >Necessita Laudo</label
                  >
                  <input
                    type="checkbox"
                    class="form-check"
                    name="necessitaLaudo"
                    id="judicial-procedure-start-form-necessitaLaudo"
                    data-cy="necessitaLaudo"
                    :class="{
                      valid: !$v.judicialProcedureProcess.judicialProcedure.necessitaLaudo.$invalid,
                      invalid: $v.judicialProcedureProcess.judicialProcedure.necessitaLaudo.$invalid,
                    }"
                    v-model="$v.judicialProcedureProcess.judicialProcedure.necessitaLaudo.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureStartForm.judge')"
                    for="judicial-procedure-start-form-judge"
                    >Judge</label
                  >
                  <select
                    class="form-control"
                    id="judicial-procedure-start-form-judge"
                    data-cy="judge"
                    name="judge"
                    v-model="judicialProcedureProcess.judicialProcedure.judge"
                  >
                    <option v-bind:value="null"></option>
                    <option
                      v-bind:value="
                        judicialProcedureProcess.judicialProcedure.judge &&
                        judgeOption.id === judicialProcedureProcess.judicialProcedure.judge.id
                          ? judicialProcedureProcess.judicialProcedure.judge
                          : judgeOption
                      "
                      v-for="judgeOption in judges"
                      :key="judgeOption.id"
                    >
                      {{ judgeOption.name }}
                    </option>
                  </select>
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.judicialProcedureProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./judicial-procedure-start-form-init.component.ts"></script>
