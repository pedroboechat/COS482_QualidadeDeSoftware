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
public class AssignReporterService {

    private final TaskInstanceService taskInstanceService;

    private final JudicialProcedureService judicialProcedureService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final JudicialProcedureProcessRepository judicialProcedureProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final AssignReporterMapper assignReporterMapper;

    private final JudicialProcedureProcessMapper judicialProcedureProcessMapper;

    public AssignReporterService(
        TaskInstanceService taskInstanceService,
        JudicialProcedureService judicialProcedureService,
        TaskInstanceRepository taskInstanceRepository,
        JudicialProcedureProcessRepository judicialProcedureProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        AssignReporterMapper assignReporterMapper,
        JudicialProcedureProcessMapper judicialProcedureProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.judicialProcedureService = judicialProcedureService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.judicialProcedureProcessRepository = judicialProcedureProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.assignReporterMapper = assignReporterMapper;
        this.judicialProcedureProcessMapper = judicialProcedureProcessMapper;
    }

    public AssignReporterContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(assignReporterMapper::toJudicialProcedureProcessDTO)
            .orElseThrow();

        AssignReporterContextDTO assignReporterContext = new AssignReporterContextDTO();
        assignReporterContext.setTaskInstance(taskInstanceDTO);
        assignReporterContext.setJudicialProcedureProcess(judicialProcedureProcess);

        return assignReporterContext;
    }

    public AssignReporterContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(AssignReporterContextDTO assignReporterContext) {
        JudicialProcedureDTO judicialProcedureDTO = judicialProcedureService
            .findOne(assignReporterContext.getJudicialProcedureProcess().getJudicialProcedure().getId())
            .orElseThrow();
        judicialProcedureDTO.setLaudista(assignReporterContext.getJudicialProcedureProcess().getJudicialProcedure().getLaudista());
        judicialProcedureDTO.setDataDaVisita(assignReporterContext.getJudicialProcedureProcess().getJudicialProcedure().getDataDaVisita());
        judicialProcedureDTO.setEndereco(assignReporterContext.getJudicialProcedureProcess().getJudicialProcedure().getEndereco());
        judicialProcedureService.save(judicialProcedureDTO);
    }

    public void complete(AssignReporterContextDTO assignReporterContext) {
        save(assignReporterContext);
        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(assignReporterContext.getJudicialProcedureProcess().getProcessInstance().getId())
            .map(judicialProcedureProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(assignReporterContext.getTaskInstance(), judicialProcedureProcess);
    }
}
