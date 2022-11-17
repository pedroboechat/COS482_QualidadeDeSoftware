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
public class ProtocolReportService {

    private final TaskInstanceService taskInstanceService;

    private final JudicialProcedureService judicialProcedureService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final JudicialProcedureProcessRepository judicialProcedureProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final ProtocolReportMapper protocolReportMapper;

    private final JudicialProcedureProcessMapper judicialProcedureProcessMapper;

    public ProtocolReportService(
        TaskInstanceService taskInstanceService,
        JudicialProcedureService judicialProcedureService,
        TaskInstanceRepository taskInstanceRepository,
        JudicialProcedureProcessRepository judicialProcedureProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        ProtocolReportMapper protocolReportMapper,
        JudicialProcedureProcessMapper judicialProcedureProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.judicialProcedureService = judicialProcedureService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.judicialProcedureProcessRepository = judicialProcedureProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.protocolReportMapper = protocolReportMapper;
        this.judicialProcedureProcessMapper = judicialProcedureProcessMapper;
    }

    public ProtocolReportContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(protocolReportMapper::toJudicialProcedureProcessDTO)
            .orElseThrow();

        ProtocolReportContextDTO protocolReportContext = new ProtocolReportContextDTO();
        protocolReportContext.setTaskInstance(taskInstanceDTO);
        protocolReportContext.setJudicialProcedureProcess(judicialProcedureProcess);

        return protocolReportContext;
    }

    public ProtocolReportContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(ProtocolReportContextDTO protocolReportContext) {
        JudicialProcedureDTO judicialProcedureDTO = judicialProcedureService
            .findOne(protocolReportContext.getJudicialProcedureProcess().getJudicialProcedure().getId())
            .orElseThrow();
        judicialProcedureDTO.setProtocoladoEm(
            protocolReportContext.getJudicialProcedureProcess().getJudicialProcedure().getProtocoladoEm()
        );
        judicialProcedureService.save(judicialProcedureDTO);
    }

    public void complete(ProtocolReportContextDTO protocolReportContext) {
        save(protocolReportContext);
        JudicialProcedureProcessDTO judicialProcedureProcess = judicialProcedureProcessRepository
            .findByProcessInstanceId(protocolReportContext.getJudicialProcedureProcess().getProcessInstance().getId())
            .map(judicialProcedureProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(protocolReportContext.getTaskInstance(), judicialProcedureProcess);
    }
}
