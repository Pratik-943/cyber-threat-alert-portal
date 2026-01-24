package com.project.cyberalert.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_preferences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

    private double radiusKm;

    private String severityLevel;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
