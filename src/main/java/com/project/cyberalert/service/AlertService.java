package com.project.cyberalert.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cyberalert.entity.Alert;
import com.project.cyberalert.entity.Threat;
import com.project.cyberalert.entity.User;
import com.project.cyberalert.repository.AlertRepository;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    // -------------------------------------
    // Create Alert
    // -------------------------------------
    public Alert createAlert(User user, Threat threat) {

        Alert alert = new Alert();

        alert.setUser(user);
        alert.setThreat(threat);
        alert.setReadStatus(false);
        alert.setSent(true);
        alert.setSentAt(LocalDateTime.now());

        return alertRepository.save(alert);
    }

    // -------------------------------------
    // Get All Alerts for User
    // -------------------------------------
    public List<Alert> getAlertsByUserId(Long userId) {

        return alertRepository.findByUserId(userId);
    }

    // -------------------------------------
    // Get Unread Alerts
    // -------------------------------------
    public List<Alert> getUnreadAlerts(Long userId) {

        return alertRepository.findByUserIdAndReadStatusFalse(userId);
    }

    // -------------------------------------
    // Mark Alert As Read
    // -------------------------------------
    public boolean markAsRead(Long alertId, Long userId) {

        Optional<Alert> optionalAlert = alertRepository.findById(alertId);

        if (optionalAlert.isEmpty()) {
            return false;
        }

        Alert alert = optionalAlert.get();

        // Check if alert belongs to the user
        if (!alert.getUser().getId().equals(userId)) {
            return false;
        }

        alert.setReadStatus(true);
        alertRepository.save(alert);

        return true;
    }
}