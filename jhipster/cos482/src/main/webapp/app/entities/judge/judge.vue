<template>
  <div>
    <h2 id="page-heading" data-cy="JudgeHeading">
      <span v-text="$t('cos482App.judge.home.title')" id="judge-heading">Judges</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('cos482App.judge.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'JudgeCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-judge"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('cos482App.judge.home.createLabel')"> Create a new Judge </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && judges && judges.length === 0">
      <span v-text="$t('cos482App.judge.home.notFound')">No judges found</span>
    </div>
    <div class="table-responsive" v-if="judges && judges.length > 0">
      <table class="table table-striped" aria-describedby="judges">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('cos482App.judge.name')">Name</span></th>
            <th scope="row"><span v-text="$t('cos482App.judge.cpf')">Cpf</span></th>
            <th scope="row"><span v-text="$t('cos482App.judge.oab')">Oab</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="judge in judges" :key="judge.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'JudgeView', params: { judgeId: judge.id } }">{{ judge.id }}</router-link>
            </td>
            <td>{{ judge.name }}</td>
            <td>{{ judge.cpf }}</td>
            <td>{{ judge.oab }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'JudgeView', params: { judgeId: judge.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'JudgeEdit', params: { judgeId: judge.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(judge)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="cos482App.judge.delete.question" data-cy="judgeDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-judge-heading" v-text="$t('cos482App.judge.delete.question', { id: removeId })">
          Are you sure you want to delete this Judge?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-judge"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeJudge()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./judge.component.ts"></script>
