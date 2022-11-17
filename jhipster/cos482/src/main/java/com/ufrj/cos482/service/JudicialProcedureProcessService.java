package com.ufrj.cos482.service;

import com.ufrj.cos482.domain.JudicialProcedureProcess;
import com.ufrj.cos482.repository.JudicialProcedureProcessRepository;
import com.ufrj.cos482.repository.JudicialProcedureRepository;
import com.ufrj.cos482.service.dto.JudicialProcedureProcessDTO;
import com.ufrj.cos482.service.mapper.JudicialProcedureProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link JudicialProcedureProcess}.
 */
@Service
@Transactional
public class JudicialProcedureProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "JudicialProcedure";

    private final Logger log = LoggerFactory.getLogger(JudicialProcedureProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final JudicialProcedureRepository judicialProcedureRepository;

    private final JudicialProcedureProcessRepository judicialProcedureProcessRepository;

    private final JudicialProcedureProcessMapper judicialProcedureProcessMapper;

    public JudicialProcedureProcessService(
        ProcessInstanceService processInstanceService,
        JudicialProcedureRepository judicialProcedureRepository,
        JudicialProcedureProcessRepository judicialProcedureProcessRepository,
        JudicialProcedureProcessMapper judicialProcedureProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.judicialProcedureRepository = judicialProcedureRepository;
        this.judicialProcedureProcessRepository = judicialProcedureProcessRepository;
        this.judicialProcedureProcessMapper = judicialProcedureProcessMapper;
    }

    /**
     * Save a judicialProcedureProcess.
     *
     * @param judicialProcedureProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public JudicialProcedureProcessDTO create(JudicialProcedureProcessDTO judicialProcedureProcessDTO) {
        log.debug("Request to save JudicialProcedureProcess : {}", judicialProcedureProcessDTO);

        JudicialProcedureProcess judicialProcedureProcess = judicialProcedureProcessMapper.toEntity(judicialProcedureProcessDTO);

        //Saving the domainEntity
        judicialProcedureRepository.save(judicialProcedureProcess.getJudicialProcedure());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "JudicialProcedure#" + judicialProcedureProcess.getJudicialProcedure().getId(),
            judicialProcedureProcess
        );
        judicialProcedureProcess.setProcessInstance(processInstance);

        //Saving the process entity
        judicialProcedureProcess = judicialProcedureProcessRepository.save(judicialProcedureProcess);
        return judicialProcedureProcessMapper.toDto(judicialProcedureProcess);
    }

    /**
     * Get all the judicialProcedureProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<JudicialProcedureProcessDTO> findAll() {
        log.debug("Request to get all JudicialProcedureProcesss");
        return judicialProcedureProcessRepository
            .findAll()
            .stream()
            .map(judicialProcedureProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one judicialProcedureProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JudicialProcedureProcessDTO> findOne(Long id) {
        log.debug("Request to get JudicialProcedureProcess : {}", id);
        return judicialProcedureProcessRepository.findById(id).map(judicialProcedureProcessMapper::toDto);
    }

    /**
     * Get one judicialProcedureProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JudicialProcedureProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get JudicialProcedureProcess by  processInstanceId: {}", processInstanceId);
        return judicialProcedureProcessRepository.findByProcessInstanceId(processInstanceId).map(judicialProcedureProcessMapper::toDto);
    }
}
