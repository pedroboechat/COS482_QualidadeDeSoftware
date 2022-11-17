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
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.NumeroDoProcesso')"
                    >NumeroDoProcesso</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="NumeroDoProcesso"
                    id="judicial-procedure-NumeroDoProcesso"
                    data-cy="NumeroDoProcesso"
                    v-model="judicialProcedureProcess.judicialProcedure.NumeroDoProcesso"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.Tribunal')">Tribunal</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="Tribunal"
                    id="judicial-procedure-Tribunal"
                    data-cy="Tribunal"
                    v-model="judicialProcedureProcess.judicialProcedure.Tribunal"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.Juiz')">Juiz</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="Juiz"
                    id="judicial-procedure-Juiz"
                    data-cy="Juiz"
                    v-model="judicialProcedureProcess.judicialProcedure.Juiz"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.NecessitaLaudo')">NecessitaLaudo</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="NecessitaLaudo"
                    id="judicial-procedure-NecessitaLaudo"
                    data-cy="NecessitaLaudo"
                    v-model="judicialProcedureProcess.judicialProcedure.NecessitaLaudo"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.Laudista')">Laudista</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="Laudista"
                    id="judicial-procedure-Laudista"
                    data-cy="Laudista"
                    v-model="judicialProcedureProcess.judicialProcedure.Laudista"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.DataDaVisita')">DataDaVisita</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="DataDaVisita"
                    id="judicial-procedure-DataDaVisita"
                    data-cy="DataDaVisita"
                    v-model="judicialProcedureProcess.judicialProcedure.DataDaVisita"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.Endereco')">Endereco</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="Endereco"
                    id="judicial-procedure-Endereco"
                    data-cy="Endereco"
                    v-model="judicialProcedureProcess.judicialProcedure.Endereco"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.LinkLaudo')">LinkLaudo</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="LinkLaudo"
                    id="judicial-procedure-LinkLaudo"
                    data-cy="LinkLaudo"
                    v-model="judicialProcedureProcess.judicialProcedure.LinkLaudo"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.LaudoValido')">LaudoValido</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="LaudoValido"
                    id="judicial-procedure-LaudoValido"
                    data-cy="LaudoValido"
                    v-model="judicialProcedureProcess.judicialProcedure.LaudoValido"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('cos482App.judicialProcedureProcess.ProtocoladoEm')">ProtocoladoEm</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="ProtocoladoEm"
                    id="judicial-procedure-ProtocoladoEm"
                    data-cy="ProtocoladoEm"
                    v-model="judicialProcedureProcess.judicialProcedure.ProtocoladoEm"
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
