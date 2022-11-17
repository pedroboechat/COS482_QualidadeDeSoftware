package com.ufrj.cos482.web.rest;

import com.ufrj.cos482.repository.JudicialProcedureRepository;
import com.ufrj.cos482.service.JudicialProcedureService;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
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
 * REST controller for managing {@link com.ufrj.cos482.domain.JudicialProcedure}.
 */
@RestController
@RequestMapping("/api")
public class JudicialProcedureResource {

    private final Logger log = LoggerFactory.getLogger(JudicialProcedureResource.class);

    private final JudicialProcedureService judicialProcedureService;

    private final JudicialProcedureRepository judicialProcedureRepository;

    public JudicialProcedureResource(
        JudicialProcedureService judicialProcedureService,
        JudicialProcedureRepository judicialProcedureRepository
    ) {
        this.judicialProcedureService = judicialProcedureService;
        this.judicialProcedureRepository = judicialProcedureRepository;
    }

    /**
     * {@code GET  /judicial-procedures} : get all the judicialProcedures.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of judicialProcedures in body.
     */
    @GetMapping("/judicial-procedures")
    public List<JudicialProcedureDTO> getAllJudicialProcedures() {
        log.debug("REST request to get all JudicialProcedures");
        return judicialProcedureService.findAll();
    }

    /**
     * {@code GET  /judicial-procedures/:id} : get the "id" judicialProcedure.
     *
     * @param id the id of the judicialProcedureDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the judicialProcedureDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/judicial-procedures/{id}")
    public ResponseEntity<JudicialProcedureDTO> getJudicialProcedure(@PathVariable Long id) {
        log.debug("REST request to get JudicialProcedure : {}", id);
        Optional<JudicialProcedureDTO> judicialProcedureDTO = judicialProcedureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(judicialProcedureDTO);
    }
}
