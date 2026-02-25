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

    private boolean sent = true;

    // NEW FIELD (STEP-7)
    private boolean readStatus = false;

    private LocalDateTime sentAt;

    // ===== GETTERS =====

    public Long getId() { return id; }

    public Long getUserId() { return userId; }

    public Long getThreatId() { return threatId; }

    public boolean isSent() { return sent; }

    public boolean isReadStatus() { return readStatus; }

    public LocalDateTime getSentAt() { return sentAt; }

    // ===== SETTERS =====

    public void setId(Long id) { this.id = id; }

    public void setUserId(Long userId) { this.userId = userId; }

    public void setThreatId(Long threatId) { this.threatId = threatId; }

    public void setSent(boolean sent) { this.sent = sent; }

    public void setReadStatus(boolean readStatus) { this.readStatus = readStatus; }

    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
}