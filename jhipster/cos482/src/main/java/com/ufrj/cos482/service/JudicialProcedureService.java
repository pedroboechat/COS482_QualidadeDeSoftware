package com.ufrj.cos482.service;

import com.ufrj.cos482.domain.JudicialProcedure;
import com.ufrj.cos482.repository.JudicialProcedureRepository;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
import com.ufrj.cos482.service.mapper.JudicialProcedureMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link JudicialProcedure}.
 */
@Service
@Transactional
public class JudicialProcedureService {

    private final Logger log = LoggerFactory.getLogger(JudicialProcedureService.class);

    private final JudicialProcedureRepository judicialProcedureRepository;

    private final JudicialProcedureMapper judicialProcedureMapper;

    public JudicialProcedureService(
        JudicialProcedureRepository judicialProcedureRepository,
        JudicialProcedureMapper judicialProcedureMapper
    ) {
        this.judicialProcedureRepository = judicialProcedureRepository;
        this.judicialProcedureMapper = judicialProcedureMapper;
    }

    /**
     * Save a judicialProcedure.
     *
     * @param judicialProcedureDTO the entity to save.
     * @return the persisted entity.
     */
    public JudicialProcedureDTO save(JudicialProcedureDTO judicialProcedureDTO) {
        log.debug("Request to save JudicialProcedure : {}", judicialProcedureDTO);
        JudicialProcedure judicialProcedure = judicialProcedureMapper.toEntity(judicialProcedureDTO);
        judicialProcedure = judicialProcedureRepository.save(judicialProcedure);
        return judicialProcedureMapper.toDto(judicialProcedure);
    }

    /**
     * Partially update a judicialProcedure.
     *
     * @param judicialProcedureDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<JudicialProcedureDTO> partialUpdate(JudicialProcedureDTO judicialProcedureDTO) {
        log.debug("Request to partially update JudicialProcedure : {}", judicialProcedureDTO);

        return judicialProcedureRepository
            .findById(judicialProcedureDTO.getId())
            .map(
                existingJudicialProcedure -> {
                    judicialProcedureMapper.partialUpdate(existingJudicialProcedure, judicialProcedureDTO);
                    return existingJudicialProcedure;
                }
            )
            .map(judicialProcedureRepository::save)
            .map(judicialProcedureMapper::toDto);
    }

    /**
     * Get all the judicialProcedures.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<JudicialProcedureDTO> findAll() {
        log.debug("Request to get all JudicialProcedures");
        return judicialProcedureRepository
            .findAll()
            .stream()
            .map(judicialProcedureMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one judicialProcedure by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JudicialProcedureDTO> findOne(Long id) {
        log.debug("Request to get JudicialProcedure : {}", id);
        return judicialProcedureRepository.findById(id).map(judicialProcedureMapper::toDto);
    }

    /**
     * Delete the judicialProcedure by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete JudicialProcedure : {}", id);
        judicialProcedureRepository.deleteById(id);
    }
}
