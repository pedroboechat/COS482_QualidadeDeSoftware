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
                    v-text="$t('cos482App.judicialProcedureStartForm.NumeroDoProcesso')"
                    for="judicial-procedure-start-form-NumeroDoProcesso"
                    >Numero Do Processo</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="NumeroDoProcesso"
                    id="judicial-procedure-start-form-NumeroDoProcesso"
                    data-cy="NumeroDoProcesso"
                    :class="{
                      valid: !$v.judicialProcedureProcess.judicialProcedure.NumeroDoProcesso.$invalid,
                      invalid: $v.judicialProcedureProcess.judicialProcedure.NumeroDoProcesso.$invalid,
                    }"
                    v-model="$v.judicialProcedureProcess.judicialProcedure.NumeroDoProcesso.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureStartForm.Tribunal')"
                    for="judicial-procedure-start-form-Tribunal"
                    >Tribunal</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="Tribunal"
                    id="judicial-procedure-start-form-Tribunal"
                    data-cy="Tribunal"
                    :class="{
                      valid: !$v.judicialProcedureProcess.judicialProcedure.Tribunal.$invalid,
                      invalid: $v.judicialProcedureProcess.judicialProcedure.Tribunal.$invalid,
                    }"
                    v-model="$v.judicialProcedureProcess.judicialProcedure.Tribunal.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureStartForm.Juiz')"
                    for="judicial-procedure-start-form-Juiz"
                    >Juiz</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="Juiz"
                    id="judicial-procedure-start-form-Juiz"
                    data-cy="Juiz"
                    :class="{
                      valid: !$v.judicialProcedureProcess.judicialProcedure.Juiz.$invalid,
                      invalid: $v.judicialProcedureProcess.judicialProcedure.Juiz.$invalid,
                    }"
                    v-model="$v.judicialProcedureProcess.judicialProcedure.Juiz.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureStartForm.NecessitaLaudo')"
                    for="judicial-procedure-start-form-NecessitaLaudo"
                    >Necessita Laudo</label
                  >
                  <input
                    type="checkbox"
                    class="form-check"
                    name="NecessitaLaudo"
                    id="judicial-procedure-start-form-NecessitaLaudo"
                    data-cy="NecessitaLaudo"
                    :class="{
                      valid: !$v.judicialProcedureProcess.judicialProcedure.NecessitaLaudo.$invalid,
                      invalid: $v.judicialProcedureProcess.judicialProcedure.NecessitaLaudo.$invalid,
                    }"
                    v-model="$v.judicialProcedureProcess.judicialProcedure.NecessitaLaudo.$model"
                  />
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
