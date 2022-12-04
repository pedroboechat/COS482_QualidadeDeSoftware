<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="judicialProcedureProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="judicialProcedureProcessDetailsHeading">
          <span v-text="$t('cos482App.judicialProcedureProcess.detail.title')">JudicialProcedureProcess</span>
          {{ judicialProcedureProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="judicialProcedureProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('cos482App.judicialProcedureProcess.detail.title')">JudicialProcedureProcess</span> #{{
              judicialProcedureProcess.id
            }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="judicialProcedureProcess.judicialProcedure">
              <h5 class="card-header">
                <span class="title"> Judicial Procedure #{{ judicialProcedureProcess.judicialProcedure.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.numeroDoProcesso')"
                    >numeroDoProcesso</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="numeroDoProcesso"
                    id="judicial-procedure-numeroDoProcesso"
                    data-cy="numeroDoProcesso"
                    v-model="judicialProcedureProcess.judicialProcedure.numeroDoProcesso"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.tribunal')">tribunal</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="tribunal"
                    id="judicial-procedure-tribunal"
                    data-cy="tribunal"
                    v-model="judicialProcedureProcess.judicialProcedure.tribunal"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.necessitaLaudo')">necessitaLaudo</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="necessitaLaudo"
                    id="judicial-procedure-necessitaLaudo"
                    data-cy="necessitaLaudo"
                    v-model="judicialProcedureProcess.judicialProcedure.necessitaLaudo"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.laudista')">laudista</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="laudista"
                    id="judicial-procedure-laudista"
                    data-cy="laudista"
                    v-model="judicialProcedureProcess.judicialProcedure.laudista"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.dataDaVisita')">dataDaVisita</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="dataDaVisita"
                    id="judicial-procedure-dataDaVisita"
                    data-cy="dataDaVisita"
                    v-model="judicialProcedureProcess.judicialProcedure.dataDaVisita"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.endereco')">endereco</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="endereco"
                    id="judicial-procedure-endereco"
                    data-cy="endereco"
                    v-model="judicialProcedureProcess.judicialProcedure.endereco"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.linkLaudo')">linkLaudo</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="linkLaudo"
                    id="judicial-procedure-linkLaudo"
                    data-cy="linkLaudo"
                    v-model="judicialProcedureProcess.judicialProcedure.linkLaudo"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.laudoValido')">laudoValido</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="laudoValido"
                    id="judicial-procedure-laudoValido"
                    data-cy="laudoValido"
                    v-model="judicialProcedureProcess.judicialProcedure.laudoValido"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.protocoladoEm')">protocoladoEm</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="protocoladoEm"
                    id="judicial-procedure-protocoladoEm"
                    data-cy="protocoladoEm"
                    v-model="judicialProcedureProcess.judicialProcedure.protocoladoEm"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('cos482App.judicialProcedureProcess.judge')"
                    for="judicial-procedure-process-judge"
                    >Judge</label
                  >
                  <input
                    v-if="judicialProcedureProcess.judicialProcedure.judge"
                    readonly
                    type="text"
                    class="form-control"
                    name="judge"
                    id="judicial-procedure-judge"
                    data-cy="judge"
                    :value="judicialProcedureProcess.judicialProcedure.judge.name"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="judge"
                    id="judicial-procedure-judge"
                    data-cy="judge"
                    value=""
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./judicial-procedure-process-details.component.ts"></script>
