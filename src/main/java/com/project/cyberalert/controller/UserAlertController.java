package com.project.cyberalert.controller;

import com.project.cyberalert.entity.Alert;
import com.project.cyberalert.entity.User;
import com.project.cyberalert.repository.UserRepository;
import com.project.cyberalert.service.AlertService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAlertController {

    private final AlertService alertService;
    private final UserRepository userRepository;

    public UserAlertController(AlertService alertService,
                               UserRepository userRepository) {
        this.alertService = alertService;
        this.userRepository = userRepository;
    }

    // 🔹 Get All Alerts
    @GetMapping("/alerts")
    public List<Alert> getUserAlerts(Authentication authentication) {

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return alertService.getAlertsByUserId(user.getId());
    }

    // 🔹 Get Unread Alerts
    @GetMapping("/alerts/unread")
    public List<Alert> getUnreadAlerts(Authentication authentication) {

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return alertService.getUnreadAlerts(user.getId());
    }

    // 🔹 Mark Alert As Read
    @PutMapping("/alerts/{id}/read")
    public String markAlertAsRead(@PathVariable Long id,
                                  Authentication authentication) {

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean updated = alertService.markAsRead(id, user.getId());

        if (!updated) {
            return "Alert not found or does not belong to this user";
        }

        return "Alert marked as read successfully";
    }
}