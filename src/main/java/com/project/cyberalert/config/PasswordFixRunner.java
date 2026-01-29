package com.project.cyberalert.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordFixRunner {

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    public void fixAdminPassword() {
        String raw = "admin123";
        String encoded = encoder.encode(raw);
//        System.out.println("BCrypt(admin123) = " + encoded);
    }
}
