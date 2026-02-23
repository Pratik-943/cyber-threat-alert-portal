package com.project.cyberalert.service;

import com.project.cyberalert.entity.Alert;
import com.project.cyberalert.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert createAlert(Long userId, Long threatId) {

        Alert alert = new Alert();
        alert.setUserId(userId);
        alert.setThreatId(threatId);
        alert.setSent(true);
        alert.setSentAt(LocalDateTime.now());

        return alertRepository.save(alert);
    }
}