<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="cos482App.judge.home.createOrEditLabel"
          data-cy="JudgeCreateUpdateHeading"
          v-text="$t('cos482App.judge.home.createOrEditLabel')"
        >
          Create or edit a Judge
        </h2>
        <div>
          <div class="form-group" v-if="judge.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="judge.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('cos482App.judge.name')" for="judge-name">Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="judge-name"
              data-cy="name"
              :class="{ valid: !$v.judge.name.$invalid, invalid: $v.judge.name.$invalid }"
              v-model="$v.judge.name.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('cos482App.judge.cpf')" for="judge-cpf">Cpf</label>
            <input
              type="text"
              class="form-control"
              name="cpf"
              id="judge-cpf"
              data-cy="cpf"
              :class="{ valid: !$v.judge.cpf.$invalid, invalid: $v.judge.cpf.$invalid }"
              v-model="$v.judge.cpf.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('cos482App.judge.oab')" for="judge-oab">Oab</label>
            <input
              type="text"
              class="form-control"
              name="oab"
              id="judge-oab"
              data-cy="oab"
              :class="{ valid: !$v.judge.oab.$invalid, invalid: $v.judge.oab.$invalid }"
              v-model="$v.judge.oab.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.judge.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./judge-update.component.ts"></script>
