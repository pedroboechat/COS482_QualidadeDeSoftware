package com.ufrj.cos482.web.rest;

import com.ufrj.cos482.service.JudicialProcedureProcessService;
import com.ufrj.cos482.service.dto.JudicialProcedureProcessDTO;
import com.ufrj.cos482.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.ufrj.cos482.domain.JudicialProcedureProcess}.
 */
@RestController
@RequestMapping("/api")
public class JudicialProcedureProcessResource {

    private final Logger log = LoggerFactory.getLogger(JudicialProcedureProcessResource.class);

    private static final String ENTITY_NAME = "judicialProcedureProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JudicialProcedureProcessService judicialProcedureProcessService;

    public JudicialProcedureProcessResource(JudicialProcedureProcessService judicialProcedureProcessService) {
        this.judicialProcedureProcessService = judicialProcedureProcessService;
    }

    /**
     * {@code POST  /judicial-procedure-processes} : Create a new judicialProcedureProcess.
     *
     * @param judicialProcedureProcessDTO the judicialProcedureProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new judicialProcedureProcessDTO, or with status {@code 400 (Bad Request)} if the judicialProcedureProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/judicial-procedure-processes")
    public ResponseEntity<JudicialProcedureProcessDTO> create(@RequestBody JudicialProcedureProcessDTO judicialProcedureProcessDTO)
        throws URISyntaxException {
        log.debug("REST request to save JudicialProcedureProcess : {}", judicialProcedureProcessDTO);
        if (judicialProcedureProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new judicialProcedureProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JudicialProcedureProcessDTO result = judicialProcedureProcessService.create(judicialProcedureProcessDTO);
        return ResponseEntity
            .created(new URI("/api/judicial-procedure-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /judicial-procedure-processes} : get all the judicialProcedureProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of judicialProcedureProcesss in body.
     */
    @GetMapping("/judicial-procedure-processes")
    public List<JudicialProcedureProcessDTO> getAllJudicialProcedureProcesss() {
        log.debug("REST request to get all JudicialProcedureProcesss");
        return judicialProcedureProcessService.findAll();
    }

    /**
     * {@code GET  /judicial-procedure-processes/:id} : get the "id" judicialProcedureProcess.
     *
     * @param processInstanceId the id of the judicialProcedureProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the judicialProcedureProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/judicial-procedure-processes/{processInstanceId}")
    public ResponseEntity<JudicialProcedureProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get JudicialProcedureProcess by processInstanceId : {}", processInstanceId);
        Optional<JudicialProcedureProcessDTO> judicialProcedureProcessDTO = judicialProcedureProcessService.findByProcessInstanceId(
            processInstanceId
        );
        return ResponseUtil.wrapOrNotFound(judicialProcedureProcessDTO);
    }
}
