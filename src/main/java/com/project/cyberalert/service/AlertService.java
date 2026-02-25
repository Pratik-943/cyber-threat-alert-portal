package com.project.cyberalert.service;

import com.project.cyberalert.entity.Alert;
import com.project.cyberalert.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    // STEP-6: Create Alert
    public Alert createAlert(Long userId, Long threatId) {

        Alert alert = new Alert();
        alert.setUserId(userId);
        alert.setThreatId(threatId);
        alert.setSent(true);
        alert.setReadStatus(false);
        alert.setSentAt(LocalDateTime.now());

        return alertRepository.save(alert);
    }

    // Get All Alerts
    public List<Alert> getAlertsByUserId(Long userId) {
        return alertRepository.findByUserId(userId);
    }

    // Get Unread Alerts
    public List<Alert> getUnreadAlerts(Long userId) {
        return alertRepository.findByUserIdAndReadStatusFalse(userId);
    }

    // Mark Alert As Read (SAFE VERSION)
    public boolean markAsRead(Long alertId, Long userId) {

        Optional<Alert> optionalAlert =
                alertRepository.findByIdAndUserId(alertId, userId);

        if (optionalAlert.isEmpty()) {
            return false;
        }

        Alert alert = optionalAlert.get();
        alert.setReadStatus(true);
        alertRepository.save(alert);

        return true;
    }
}