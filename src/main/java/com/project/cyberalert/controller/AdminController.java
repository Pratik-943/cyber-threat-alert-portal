package com.project.cyberalert.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/test")
    public String adminTest() {
        return "ADMIN ACCESS GRANTED";
    }
}
