package com.project.cyberalert.repository;

import com.project.cyberalert.entity.Threat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreatRepository extends JpaRepository<Threat, Long> {
    // No custom methods yet (safe & stable)
}
