package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Activity;
import com.bezkoder.spring.login.payload.request.ActivityRequest;
import com.bezkoder.spring.login.payload.request.SignupRequest;
import com.bezkoder.spring.login.payload.response.MessageResponse;
import com.bezkoder.spring.login.repository.ActivityRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost:8081", "http://localhost:8100"}, allowCredentials = "true", allowedHeaders = "*")

@RestController
@RequestMapping("/api/activity")

public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    /** API endpoint per la creaizone di una attività */
    @GetMapping("/create")
        public ResponseEntity<?> createActivity(@Valid @RequestBody ActivityRequest activityRequest) {

            Activity a = new Activity();

            // TODO: prendi parametro da activity request
            a.setName("test");

            activityRepository.save(a);
            System.out.println("creato nome nel db");

        return ResponseEntity.ok(new MessageResponse("Activity added successfully"));

        }
}
