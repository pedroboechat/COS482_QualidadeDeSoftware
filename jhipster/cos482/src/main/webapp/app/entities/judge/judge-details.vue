<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="judge">
        <h2 class="jh-entity-heading" data-cy="judgeDetailsHeading">
          <span v-text="$t('cos482App.judge.detail.title')">Judge</span> {{ judge.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('cos482App.judge.name')">Name</span>
          </dt>
          <dd>
            <span>{{ judge.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judge.cpf')">Cpf</span>
          </dt>
          <dd>
            <span>{{ judge.cpf }}</span>
          </dd>
          <dt>
            <span v-text="$t('cos482App.judge.oab')">Oab</span>
          </dt>
          <dd>
            <span>{{ judge.oab }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link v-if="judge.id" :to="{ name: 'JudgeEdit', params: { judgeId: judge.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./judge-details.component.ts"></script>
