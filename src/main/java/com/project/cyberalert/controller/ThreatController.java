package com.project.cyberalert.controller;

import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.repository.ThreatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/threats")
public class ThreatController {

    private final ThreatRepository threatRepository;

    public ThreatController(ThreatRepository threatRepository) {
        this.threatRepository = threatRepository;
    }

    @GetMapping
    public List<Threat> getAllThreats() {
        return threatRepository.findAll();
    }
}
