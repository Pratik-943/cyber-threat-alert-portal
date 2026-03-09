package com.project.cyberalert.repository;

import com.project.cyberalert.entity.Threat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ThreatRepository extends JpaRepository<Threat, Long> {

    List<Threat> findBySeverityNotIn(List<String> severity);

}