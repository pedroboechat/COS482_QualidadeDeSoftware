package com.ufrj.cos482.web.rest;

import com.ufrj.cos482.repository.JudgeRepository;
import com.ufrj.cos482.service.JudgeService;
import com.ufrj.cos482.service.dto.JudgeDTO;
import com.ufrj.cos482.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.ufrj.cos482.domain.Judge}.
 */
@RestController
@RequestMapping("/api")
public class JudgeResource {

    private final Logger log = LoggerFactory.getLogger(JudgeResource.class);

    private static final String ENTITY_NAME = "judge";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JudgeService judgeService;

    private final JudgeRepository judgeRepository;

    public JudgeResource(JudgeService judgeService, JudgeRepository judgeRepository) {
        this.judgeService = judgeService;
        this.judgeRepository = judgeRepository;
    }

    /**
     * {@code POST  /judges} : Create a new judge.
     *
     * @param judgeDTO the judgeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new judgeDTO, or with status {@code 400 (Bad Request)} if the judge has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/judges")
    public ResponseEntity<JudgeDTO> createJudge(@RequestBody JudgeDTO judgeDTO) throws URISyntaxException {
        log.debug("REST request to save Judge : {}", judgeDTO);
        if (judgeDTO.getId() != null) {
            throw new BadRequestAlertException("A new judge cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JudgeDTO result = judgeService.save(judgeDTO);
        return ResponseEntity
            .created(new URI("/api/judges/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /judges/:id} : Updates an existing judge.
     *
     * @param id the id of the judgeDTO to save.
     * @param judgeDTO the judgeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated judgeDTO,
     * or with status {@code 400 (Bad Request)} if the judgeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the judgeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/judges/{id}")
    public ResponseEntity<JudgeDTO> updateJudge(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody JudgeDTO judgeDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Judge : {}, {}", id, judgeDTO);
        if (judgeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, judgeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!judgeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        JudgeDTO result = judgeService.save(judgeDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, judgeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /judges/:id} : Partial updates given fields of an existing judge, field will ignore if it is null
     *
     * @param id the id of the judgeDTO to save.
     * @param judgeDTO the judgeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated judgeDTO,
     * or with status {@code 400 (Bad Request)} if the judgeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the judgeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the judgeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/judges/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<JudgeDTO> partialUpdateJudge(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody JudgeDTO judgeDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Judge partially : {}, {}", id, judgeDTO);
        if (judgeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, judgeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!judgeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<JudgeDTO> result = judgeService.partialUpdate(judgeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, judgeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /judges} : get all the judges.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of judges in body.
     */
    @GetMapping("/judges")
    public List<JudgeDTO> getAllJudges() {
        log.debug("REST request to get all Judges");
        return judgeService.findAll();
    }

    /**
     * {@code GET  /judges/:id} : get the "id" judge.
     *
     * @param id the id of the judgeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the judgeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/judges/{id}")
    public ResponseEntity<JudgeDTO> getJudge(@PathVariable Long id) {
        log.debug("REST request to get Judge : {}", id);
        Optional<JudgeDTO> judgeDTO = judgeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(judgeDTO);
    }

    /**
     * {@code DELETE  /judges/:id} : delete the "id" judge.
     *
     * @param id the id of the judgeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/judges/{id}")
    public ResponseEntity<Void> deleteJudge(@PathVariable Long id) {
        log.debug("REST request to delete Judge : {}", id);
        judgeService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
