package com.ufrj.cos482.process.judicialProcedureProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/judicial-procedure-process/protocol-report")
public class ProtocolReportController {

    private final Logger log = LoggerFactory.getLogger(ProtocolReportController.class);

    private final ProtocolReportService protocolReportService;

    public ProtocolReportController(ProtocolReportService protocolReportService) {
        this.protocolReportService = protocolReportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProtocolReportContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ProtocolReportContextDTO protocolReportContext = protocolReportService.loadContext(id);
        return ResponseEntity.ok(protocolReportContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<ProtocolReportContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        ProtocolReportContextDTO protocolReportContext = protocolReportService.claim(id);
        return ResponseEntity.ok(protocolReportContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody ProtocolReportContextDTO protocolReportContext) {
        log.debug("REST request to complete JudicialProcedureProcess.ProtocolReport {}", protocolReportContext.getTaskInstance().getId());
        protocolReportService.complete(protocolReportContext);
        return ResponseEntity.noContent().build();
    }
}
