package com.ufrj.cos482.process.judicialProcedureProcess;

import com.ufrj.cos482.service.dto.JudicialProcedureProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class ValidateReportContextDTO {

    private JudicialProcedureProcessDTO judicialProcedureProcess;
    private TaskInstanceDTO taskInstance;

    public JudicialProcedureProcessDTO getJudicialProcedureProcess() {
        return judicialProcedureProcess;
    }

    public void setJudicialProcedureProcess(JudicialProcedureProcessDTO judicialProcedureProcess) {
        this.judicialProcedureProcess = judicialProcedureProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
