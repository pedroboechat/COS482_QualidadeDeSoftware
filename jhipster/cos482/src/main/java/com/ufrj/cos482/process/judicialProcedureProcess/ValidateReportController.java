package com.ufrj.cos482.process.judicialProcedureProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/judicial-procedure-process/validate-report")
public class ValidateReportController {

    private final Logger log = LoggerFactory.getLogger(ValidateReportController.class);

    private final ValidateReportService validateReportService;

    public ValidateReportController(ValidateReportService validateReportService) {
        this.validateReportService = validateReportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidateReportContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ValidateReportContextDTO validateReportContext = validateReportService.loadContext(id);
        return ResponseEntity.ok(validateReportContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<ValidateReportContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ValidateReportContextDTO validateReportContext = validateReportService.claim(id);
        return ResponseEntity.ok(validateReportContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody ValidateReportContextDTO validateReportContext) {
        log.debug("REST request to complete JudicialProcedureProcess.ValidateReport {}", validateReportContext.getTaskInstance().getId());
        validateReportService.complete(validateReportContext);
        return ResponseEntity.noContent().build();
    }
}
