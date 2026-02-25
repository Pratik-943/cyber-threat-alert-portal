package com.project.cyberalert.repository;

import com.project.cyberalert.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlertRepository extends JpaRepository<Alert, Long> {

    List<Alert> findByUserId(Long userId);

    List<Alert> findByUserIdAndReadStatusFalse(Long userId);

    Optional<Alert> findByIdAndUserId(Long alertId, Long userId);
}