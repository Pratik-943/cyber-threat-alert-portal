package com.project.cyberalert.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ---------------------------
    // Relationship with User
    // ---------------------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ---------------------------
    // Alert Filtering Logic
    // ---------------------------
    @Column(name = "min_severity")
    private String minSeverity;

    @Column(name = "radius_km")
    private Double radiusKm;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    // ---------------------------
    // Getters and Setters
    // ---------------------------

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getMinSeverity() {
        return minSeverity;
    }

    public Double getRadiusKm() {
        return radiusKm;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMinSeverity(String minSeverity) {
        this.minSeverity = minSeverity;
    }

    public void setRadiusKm(Double radiusKm) {
        this.radiusKm = radiusKm;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}