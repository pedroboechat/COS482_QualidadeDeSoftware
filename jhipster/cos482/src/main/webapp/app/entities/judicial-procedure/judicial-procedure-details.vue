<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="judicialProcedure">
        <h2 class="jh-entity-heading" data-cy="judicialProcedureDetailsHeading">
          <span v-text="$t('cos482App.judicialProcedure.detail.title')">JudicialProcedure</span> {{ judicialProcedure.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.NumeroDoProcesso')">Numero Do Processo</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.NumeroDoProcesso }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.Tribunal')">Tribunal</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.Tribunal }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.Juiz')">Juiz</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.Juiz }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.NecessitaLaudo')">Necessita Laudo</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.NecessitaLaudo }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.Laudista')">Laudista</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.Laudista }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.DataDaVisita')">Data Da Visita</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.DataDaVisita }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.Endereco')">Endereco</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.Endereco }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.LinkLaudo')">Link Laudo</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.LinkLaudo }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.LaudoValido')">Laudo Valido</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.LaudoValido }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.ProtocoladoEm')">Protocolado Em</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.ProtocoladoEm }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./judicial-procedure-details.component.ts"></script>
