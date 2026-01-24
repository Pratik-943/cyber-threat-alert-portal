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

    private boolean sent;

    private LocalDateTime sentAt;

    // getters & setters
}
