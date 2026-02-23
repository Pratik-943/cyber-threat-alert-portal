package com.project.cyberalert.service;

import com.project.cyberalert.entity.UserPreference;
import com.project.cyberalert.repository.UserPreferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferenceService {

    private final UserPreferenceRepository repository;

    public UserPreferenceService(UserPreferenceRepository repository) {
        this.repository = repository;
    }

    public List<UserPreference> getAllPreferences() {
        return repository.findAll();
    }
}