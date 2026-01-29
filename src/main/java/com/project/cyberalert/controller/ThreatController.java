package com.project.cyberalert.controller;

import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.service.ThreatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/threats")
public class ThreatController {

    private final ThreatService threatService;

    public ThreatController(ThreatService threatService) {
        this.threatService = threatService;
    }

    // ADMIN / API can add threat
    @PostMapping
    public ResponseEntity<Threat> addThreat(@RequestBody Threat threat) {
        return ResponseEntity.ok(threatService.saveThreat(threat));
    }

    // Dashboard / Map API
    @GetMapping
    public ResponseEntity<List<Threat>> getAllThreats() {
        return ResponseEntity.ok(threatService.getAllThreats());
    }
}
