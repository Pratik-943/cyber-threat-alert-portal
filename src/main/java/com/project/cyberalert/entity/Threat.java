package com.project.cyberalert.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "threats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Threat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String description;
    private String severity;

    private double latitude;
    private double longitude;
}
