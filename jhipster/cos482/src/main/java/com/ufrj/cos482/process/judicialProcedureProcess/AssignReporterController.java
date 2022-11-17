package com.ufrj.cos482.process.judicialProcedureProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/judicial-procedure-process/assign-reporter")
public class AssignReporterController {

    private final Logger log = LoggerFactory.getLogger(AssignReporterController.class);

    private final AssignReporterService assignReporterService;

    public AssignReporterController(AssignReporterService assignReporterService) {
        this.assignReporterService = assignReporterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignReporterContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AssignReporterContextDTO assignReporterContext = assignReporterService.loadContext(id);
        return ResponseEntity.ok(assignReporterContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<AssignReporterContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        AssignReporterContextDTO assignReporterContext = assignReporterService.claim(id);
        return ResponseEntity.ok(assignReporterContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody AssignReporterContextDTO assignReporterContext) {
        log.debug("REST request to complete JudicialProcedureProcess.AssignReporter {}", assignReporterContext.getTaskInstance().getId());
        assignReporterService.complete(assignReporterContext);
        return ResponseEntity.noContent().build();
    }
}
