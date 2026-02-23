package com.project.cyberalert.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;

    private double longitude;

    private double radiusKm;

    private String severityLevel;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ===== Getters & Setters =====

    public Long getId() { return id; }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getRadiusKm() { return radiusKm; }

    public void setRadiusKm(double radiusKm) { this.radiusKm = radiusKm; }

    public String getSeverityLevel() { return severityLevel; }

    public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}