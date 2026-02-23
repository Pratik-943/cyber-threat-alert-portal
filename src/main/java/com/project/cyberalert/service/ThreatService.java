package com.project.cyberalert.service;

import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.entity.UserPreference;
import com.project.cyberalert.repository.ThreatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreatService {

    private final ThreatRepository threatRepository;
    private final UserPreferenceService preferenceService;
    private final AlertService alertService;

    public ThreatService(
            ThreatRepository threatRepository,
            UserPreferenceService preferenceService,
            AlertService alertService) {

        this.threatRepository = threatRepository;
        this.preferenceService = preferenceService;
        this.alertService = alertService;
    }

    public Threat saveThreat(Threat threat) {

        Threat savedThreat = threatRepository.save(threat);

        // 🔥 STEP-6 ALERT ENGINE
        generateAlerts(savedThreat);

        return savedThreat;
    }

    public List<Threat> getAllThreats() {
        return threatRepository.findAll();
    }

    private void generateAlerts(Threat threat) {

        List<UserPreference> preferences = preferenceService.getAllPreferences();

        for (UserPreference pref : preferences) {

            // Severity filter
            if (!pref.getSeverityLevel().equalsIgnoreCase(threat.getSeverity())) {
                continue;
            }

            double distance = calculateDistance(
                    threat.getLatitude(),
                    threat.getLongitude(),
                    pref.getLatitude(),
                    pref.getLongitude()
            );

            if (distance <= pref.getRadiusKm()) {
                alertService.createAlert(
                        pref.getUser().getId(),
                        threat.getId()
                );
            }
        }
    }

    // Haversine formula
    private double calculateDistance(
            double lat1, double lon1,
            double lat2, double lon2) {

        final int EARTH_RADIUS = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2)
                * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}