package com.project.cyberalert.controller;

import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.service.ThreatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ThreatController {

    @Autowired
    private ThreatService threatService;

    @GetMapping("/public/threats")
    public List<Threat> getPublicThreats() {
        return threatService.getPublicThreats();
    }

    @GetMapping("/threats")
    public List<Threat> getAllThreats() {
        return threatService.getAllThreats();
    }

    @PostMapping("/admin/threat")
    public Threat createThreat(@RequestBody Threat threat) {
        return threatService.createThreat(threat);
    }

    @DeleteMapping("/admin/threat/{id}")
    public void deleteThreat(@PathVariable Long id) {
        threatService.deleteThreat(id);
    }

}