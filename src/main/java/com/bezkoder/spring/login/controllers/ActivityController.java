package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Activity;
import com.bezkoder.spring.login.models.ERole;
import com.bezkoder.spring.login.models.Role;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.payload.request.ActivityRequest;
import com.bezkoder.spring.login.payload.request.SignupRequest;
import com.bezkoder.spring.login.payload.response.MessageResponse;
import com.bezkoder.spring.login.repository.ActivityRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

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
    @PostMapping("/create")
        public ResponseEntity<?> createActivity(@Valid @RequestBody ActivityRequest activityRequest) {

            // Crea un oggetto attività da activityRequest
            Activity activity = new Activity(
                    activityRequest.getNome(),
                    activityRequest.getDescrizione(),
                    activityRequest.getDataInizio(),
                    activityRequest.getDataFine()
            );

            // Andiamo a salvare il nostro oggetto nel DB
            try {
                Activity savedActivity = activityRepository.save(activity);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error storing data in the database"));
            }

            //TODO: qua non uso ancora ActivityResponse, dato che sto salvango un oggetto nel DB e non mi serve restituire un dato, ma un messaggio
            return ResponseEntity.ok(new MessageResponse("Activity added successfully"));

        }
}
