package com.project.cyberalert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cyberalert.entity.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {

    List<Alert> findByUserId(Long userId);

    List<Alert> findByUserIdAndReadStatusFalse(Long userId);
}