package com.project.cyberalert.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ----------------------------------
    // Relationship with User
    // ----------------------------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ----------------------------------
    // Relationship with Threat
    // ----------------------------------
    @ManyToOne
    @JoinColumn(name = "threat_id")
    private Threat threat;

    // ----------------------------------
    // Alert Status Fields
    // ----------------------------------
    @Column(name = "read_status")
    private boolean readStatus;

    @Column(name = "sent")
    private boolean sent;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    // ----------------------------------
    // Getters
    // ----------------------------------

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Threat getThreat() {
        return threat;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public boolean isSent() {
        return sent;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    // ----------------------------------
    // Setters
    // ----------------------------------

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setThreat(Threat threat) {
        this.threat = threat;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}