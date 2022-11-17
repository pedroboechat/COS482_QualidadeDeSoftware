<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('cos482App.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('cos482App.assignReport.linkLaudo')" for="assign-report-linkLaudo"
                >Link Laudo</label
              >
              <input
                type="text"
                class="form-control"
                name="linkLaudo"
                id="assign-report-linkLaudo"
                data-cy="linkLaudo"
                :class="{
                  valid: !$v.taskContext.judicialProcedureProcess.judicialProcedure.linkLaudo.$invalid,
                  invalid: $v.taskContext.judicialProcedureProcess.judicialProcedure.linkLaudo.$invalid,
                }"
                v-model="$v.taskContext.judicialProcedureProcess.judicialProcedure.linkLaudo.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./assign-report-execute.component.ts"></script>
