package com.project.cyberalert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.entity.UserPreference;
import com.project.cyberalert.repository.ThreatRepository;

@Service
public class ThreatService {

    @Autowired
    private ThreatRepository threatRepository;

    @Autowired
    private UserPreferenceService preferenceService;

    @Autowired
    private AlertService alertService;

    // -------------------------------------
    // Save Threat (Admin adds threat)
    // -------------------------------------
    public Threat saveThreat(Threat threat) {

        Threat savedThreat = threatRepository.save(threat);

        // Generate alerts for users
        generateAlerts(savedThreat);

        return savedThreat;
    }

    // -------------------------------------
    // Get All Threats
    // -------------------------------------
    public List<Threat> getAllThreats() {
        return threatRepository.findAll();
    }

    // -------------------------------------
    // Generate Alerts For Users
    // -------------------------------------
    private void generateAlerts(Threat threat) {

        List<UserPreference> preferences = preferenceService.getAllPreferences();

        for (UserPreference pref : preferences) {

            // -------------------------------------
            // Severity Filter
            // -------------------------------------
            if (pref.getMinSeverity() != null) {

                String threatSeverity = threat.getSeverity().toUpperCase();
                String minSeverity = pref.getMinSeverity().toUpperCase();

                if (!isSeverityAllowed(threatSeverity, minSeverity)) {
                    continue;
                }
            }

            // -------------------------------------
            // Distance Calculation
            // -------------------------------------
            double distance = calculateDistance(
                    threat.getLatitude(),
                    threat.getLongitude(),
                    pref.getLatitude(),
                    pref.getLongitude()
            );

            // -------------------------------------
            // Radius Filter
            // -------------------------------------
            if (distance <= pref.getRadiusKm()) {

                alertService.createAlert(
                        pref.getUser(),
                        threat
                );
            }
        }
    }

    // -------------------------------------
    // Severity Ranking Logic
    // -------------------------------------
    private boolean isSeverityAllowed(String threatSeverity, String minSeverity) {

        List<String> severityOrder = List.of(
                "LOW",
                "MEDIUM",
                "HIGH",
                "CRITICAL"
        );

        int threatIndex = severityOrder.indexOf(threatSeverity);
        int minIndex = severityOrder.indexOf(minSeverity);

        return threatIndex >= minIndex;
    }

    // -------------------------------------
    // Distance Calculation (Haversine)
    // -------------------------------------
    private double calculateDistance(
            double lat1,
            double lon1,
            double lat2,
            double lon2) {

        final int EARTH_RADIUS = 6371; // km

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}