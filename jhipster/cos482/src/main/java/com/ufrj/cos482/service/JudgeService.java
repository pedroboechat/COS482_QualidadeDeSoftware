package com.ufrj.cos482.service;

import com.ufrj.cos482.domain.Judge;
import com.ufrj.cos482.repository.JudgeRepository;
import com.ufrj.cos482.service.dto.JudgeDTO;
import com.ufrj.cos482.service.mapper.JudgeMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Judge}.
 */
@Service
@Transactional
public class JudgeService {

    private final Logger log = LoggerFactory.getLogger(JudgeService.class);

    private final JudgeRepository judgeRepository;

    private final JudgeMapper judgeMapper;

    public JudgeService(JudgeRepository judgeRepository, JudgeMapper judgeMapper) {
        this.judgeRepository = judgeRepository;
        this.judgeMapper = judgeMapper;
    }

    /**
     * Save a judge.
     *
     * @param judgeDTO the entity to save.
     * @return the persisted entity.
     */
    public JudgeDTO save(JudgeDTO judgeDTO) {
        log.debug("Request to save Judge : {}", judgeDTO);
        Judge judge = judgeMapper.toEntity(judgeDTO);
        judge = judgeRepository.save(judge);
        return judgeMapper.toDto(judge);
    }

    /**
     * Partially update a judge.
     *
     * @param judgeDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<JudgeDTO> partialUpdate(JudgeDTO judgeDTO) {
        log.debug("Request to partially update Judge : {}", judgeDTO);

        return judgeRepository
            .findById(judgeDTO.getId())
            .map(
                existingJudge -> {
                    judgeMapper.partialUpdate(existingJudge, judgeDTO);
                    return existingJudge;
                }
            )
            .map(judgeRepository::save)
            .map(judgeMapper::toDto);
    }

    /**
     * Get all the judges.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<JudgeDTO> findAll() {
        log.debug("Request to get all Judges");
        return judgeRepository.findAll().stream().map(judgeMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one judge by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JudgeDTO> findOne(Long id) {
        log.debug("Request to get Judge : {}", id);
        return judgeRepository.findById(id).map(judgeMapper::toDto);
    }

    /**
     * Delete the judge by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Judge : {}", id);
        judgeRepository.deleteById(id);
    }
}
