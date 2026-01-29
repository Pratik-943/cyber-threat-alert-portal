package com.project.cyberalert.service;

import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.repository.ThreatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreatService {

    private final ThreatRepository threatRepository;

    public ThreatService(ThreatRepository threatRepository) {
        this.threatRepository = threatRepository;
    }

    public Threat saveThreat(Threat threat) {
        return threatRepository.save(threat);
    }

    public List<Threat> getAllThreats() {
        return threatRepository.findAll();
    }
}
