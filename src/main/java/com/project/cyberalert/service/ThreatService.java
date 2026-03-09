package com.project.cyberalert.service;

import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.repository.ThreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreatService {

    @Autowired
    private ThreatRepository threatRepository;

    public List<Threat> getAllThreats() {
        return threatRepository.findAll();
    }

    public List<Threat> getPublicThreats() {
        return threatRepository.findBySeverityNotIn(
                List.of("HIGH", "CRITICAL")
        );
    }

    public Threat createThreat(Threat threat) {
        return threatRepository.save(threat);
    }

    public void deleteThreat(Long id) {
        threatRepository.deleteById(id);
    }

}