<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="judicialProcedure">
        <h2 class="jh-entity-heading" data-cy="judicialProcedureDetailsHeading">
          <span v-text="$t('cos482App.judicialProcedure.detail.title')">JudicialProcedure</span> {{ judicialProcedure.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.numeroDoProcesso')">Numero Do Processo</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.numeroDoProcesso }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.tribunal')">Tribunal</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.tribunal }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.necessitaLaudo')">Necessita Laudo</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.necessitaLaudo }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.laudista')">Laudista</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.laudista }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.dataDaVisita')">Data Da Visita</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.dataDaVisita }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.endereco')">Endereco</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.endereco }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.linkLaudo')">Link Laudo</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.linkLaudo }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.laudoValido')">Laudo Valido</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.laudoValido }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.protocoladoEm')">Protocolado Em</span>
          </dt>
          <dd>
            <span>{{ judicialProcedure.protocoladoEm }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judicialProcedure.judge')">Judge</span>
          </dt>
          <dd>
            <div v-if="judicialProcedure.judge">
              <router-link :to="{ name: 'JudgeView', params: { judgeId: judicialProcedure.judge.id } }">{{
                judicialProcedure.judge.name
              }}</router-link>
            </div>
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
