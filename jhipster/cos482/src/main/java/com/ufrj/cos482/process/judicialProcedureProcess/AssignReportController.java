package com.ufrj.cos482.process.judicialProcedureProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/judicial-procedure-process/assign-report")
public class AssignReportController {

    private final Logger log = LoggerFactory.getLogger(AssignReportController.class);

    private final AssignReportService assignReportService;

    public AssignReportController(AssignReportService assignReportService) {
        this.assignReportService = assignReportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignReportContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AssignReportContextDTO assignReportContext = assignReportService.loadContext(id);
        return ResponseEntity.ok(assignReportContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<AssignReportContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AssignReportContextDTO assignReportContext = assignReportService.claim(id);
        return ResponseEntity.ok(assignReportContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody AssignReportContextDTO assignReportContext) {
        log.debug("REST request to complete JudicialProcedureProcess.AssignReport {}", assignReportContext.getTaskInstance().getId());
        assignReportService.complete(assignReportContext);
        return ResponseEntity.noContent().build();
    }
}
