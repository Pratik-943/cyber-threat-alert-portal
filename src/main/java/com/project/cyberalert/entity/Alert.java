package com.project.cyberalert.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long threatId;

    private boolean sent = false;

    private LocalDateTime sentAt;

    // ===== Getters & Setters =====

    public Long getId() { return id; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getThreatId() { return threatId; }

    public void setThreatId(Long threatId) { this.threatId = threatId; }

    public boolean isSent() { return sent; }

    public void setSent(boolean sent) { this.sent = sent; }

    public LocalDateTime getSentAt() { return sentAt; }

    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
}