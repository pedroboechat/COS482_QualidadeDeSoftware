package com.ufrj.cos482.process.judicialProcedureProcess;

import com.ufrj.cos482.repository.JudicialProcedureProcessRepository;
import com.ufrj.cos482.service.JudicialProcedureService;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
import com.ufrj.cos482.service.dto.JudicialProcedureProcessDTO;
import com.ufrj.cos482.service.mapper.JudicialProcedureProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class AssignReportService {

    private final TaskInstanceService taskInstanceService;

    private final JudicialProcedureService judicialProcedureService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final JudicialProcedureProcessRepository judicialProcedureProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final AssignReportMapper assignReportMapper;

    private final JudicialProcedureProcessMapper judicialProcedureProcessMapper;

    public AssignReportService(
        TaskInstanceService taskInstanceService,
        JudicialProcedureService judicialProcedureService,
        TaskInstanceRepository taskInstanceRepository,
        JudicialProcedureProcessRepository judicialProcedureProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        AssignReportMapper assignReportMapper,
        JudicialProcedureProcessMapper judicialProcedureProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.judicialProcedureService = judicialProcedureService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.judicialProcedureProcessRepository = judicialProcedureProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.assignReportMapper = assignReportMapper;
        this.judicialProcedureProcessMapper = judicialProcedureProcessMapper;
    }

    public AssignReportContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(assignReportMapper::toJudicialProcedureProcessDTO)
            .orElseThrow();

        AssignReportContextDTO assignReportContext = new AssignReportContextDTO();
        assignReportContext.setTaskInstance(taskInstanceDTO);
        assignReportContext.setJudicialProcedureProcess(judicialProcedureProcess);

        return assignReportContext;
    }

    public AssignReportContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(AssignReportContextDTO assignReportContext) {
        JudicialProcedureDTO judicialProcedureDTO = judicialProcedureService
            .findOne(assignReportContext.getJudicialProcedureProcess().getJudicialProcedure().getId())
            .orElseThrow();
        judicialProcedureDTO.setLinkLaudo(assignReportContext.getJudicialProcedureProcess().getJudicialProcedure().getLinkLaudo());
        judicialProcedureService.save(judicialProcedureDTO);
    }

    public void complete(AssignReportContextDTO assignReportContext) {
        save(assignReportContext);
        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(assignReportContext.getJudicialProcedureProcess().getProcessInstance().getId())
            .map(judicialProcedureProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(assignReportContext.getTaskInstance(), judicialProcedureProcess);
    }
}
