<template>
  <div>
    <h2 id="page-heading" data-cy="JudicialProcedureHeading">
      <span v-text="$t('cos482App.judicialProcedure.home.title')" id="judicial-procedure-heading">Judicial Procedures</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('cos482App.judicialProcedure.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && judicialProcedures && judicialProcedures.length === 0">
      <span v-text="$t('cos482App.judicialProcedure.home.notFound')">No judicialProcedures found</span>
    </div>
    <div class="table-responsive" v-if="judicialProcedures && judicialProcedures.length > 0">
      <table class="table table-striped" aria-describedby="judicialProcedures">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.numeroDoProcesso')">Numero Do Processo</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.tribunal')">Tribunal</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.necessitaLaudo')">Necessita Laudo</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.laudista')">Laudista</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.dataDaVisita')">Data Da Visita</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.endereco')">Endereco</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.linkLaudo')">Link Laudo</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.laudoValido')">Laudo Valido</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.protocoladoEm')">Protocolado Em</span></th>
            <th scope="row"><span v-text="$t('cos482App.judicialProcedure.judge')">Judge</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="judicialProcedure in judicialProcedures" :key="judicialProcedure.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'JudicialProcedureView', params: { judicialProcedureId: judicialProcedure.id } }">{{
                judicialProcedure.id
              }}</router-link>
            </td>
            <td>{{ judicialProcedure.numeroDoProcesso }}</td>
            <td>{{ judicialProcedure.tribunal }}</td>
            <td>{{ judicialProcedure.necessitaLaudo }}</td>
            <td>{{ judicialProcedure.laudista }}</td>
            <td>{{ judicialProcedure.dataDaVisita }}</td>
            <td>{{ judicialProcedure.endereco }}</td>
            <td>{{ judicialProcedure.linkLaudo }}</td>
            <td>{{ judicialProcedure.laudoValido }}</td>
            <td>{{ judicialProcedure.protocoladoEm }}</td>
            <td>
              <div v-if="judicialProcedure.judge">
                <router-link :to="{ name: 'JudgeView', params: { judgeId: judicialProcedure.judge.id } }">{{
                  judicialProcedure.judge.name
                }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'JudicialProcedureView', params: { judicialProcedureId: judicialProcedure.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="cos482App.judicialProcedure.delete.question"
          data-cy="judicialProcedureDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-judicialProcedure-heading" v-text="$t('cos482App.judicialProcedure.delete.question', { id: removeId })">
          Are you sure you want to delete this Judicial Procedure?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-judicialProcedure"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeJudicialProcedure()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./judicial-procedure.component.ts"></script>
