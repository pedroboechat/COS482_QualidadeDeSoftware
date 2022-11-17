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
public class ValidateReportService {

    private final TaskInstanceService taskInstanceService;

    private final JudicialProcedureService judicialProcedureService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final JudicialProcedureProcessRepository judicialProcedureProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ValidateReportMapper validateReportMapper;

    private final JudicialProcedureProcessMapper judicialProcedureProcessMapper;

    public ValidateReportService(
        TaskInstanceService taskInstanceService,
        JudicialProcedureService judicialProcedureService,
        TaskInstanceRepository taskInstanceRepository,
        JudicialProcedureProcessRepository judicialProcedureProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ValidateReportMapper validateReportMapper,
        JudicialProcedureProcessMapper judicialProcedureProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.judicialProcedureService = judicialProcedureService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.judicialProcedureProcessRepository = judicialProcedureProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.validateReportMapper = validateReportMapper;
        this.judicialProcedureProcessMapper = judicialProcedureProcessMapper;
    }

    public ValidateReportContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(validateReportMapper::toJudicialProcedureProcessDTO)
            .orElseThrow();

        ValidateReportContextDTO validateReportContext = new ValidateReportContextDTO();
        validateReportContext.setTaskInstance(taskInstanceDTO);
        validateReportContext.setJudicialProcedureProcess(judicialProcedureProcess);

        return validateReportContext;
    }

    public ValidateReportContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ValidateReportContextDTO validateReportContext) {
        JudicialProcedureDTO judicialProcedureDTO = judicialProcedureService
            .findOne(validateReportContext.getJudicialProcedureProcess().getJudicialProcedure().getId())
            .orElseThrow();
        judicialProcedureDTO.setLaudoValido(validateReportContext.getJudicialProcedureProcess().getJudicialProcedure().getLaudoValido());
        judicialProcedureService.save(judicialProcedureDTO);
    }

    public void complete(ValidateReportContextDTO validateReportContext) {
        save(validateReportContext);
        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(validateReportContext.getJudicialProcedureProcess().getProcessInstance().getId())
            .map(judicialProcedureProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(validateReportContext.getTaskInstance(), judicialProcedureProcess);
    }
}
