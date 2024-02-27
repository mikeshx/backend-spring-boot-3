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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
        public ResponseEntity<?> createActivity(@Valid @RequestBody ActivityRequest activityRequest, BindingResult bindingResult) {

        // BindingResult è un oggetto fornito da Spring Framework che rappresenta il risultato
        // della validazione dei dati. Viene utilizzato per raccogliere eventuali errori di validazione
        // restituisce errori 400 bad request in caso di richiesta non valida
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.badRequest().body(new MessageResponse(errorMessage.toString()));
        }

        // Parsiamo la stringa JSON che ci arriva dall'acqtivityRequest in LocalDateTime
        // settiamo il parser delle date per interpretare correttamente il formato ISO 8601
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        LocalDateTime dataInizio = null;
        LocalDateTime dataFine = null;

        try {
            dataInizio = LocalDateTime.parse(activityRequest.getDataInizio(), formatter);
            dataFine = LocalDateTime.parse(activityRequest.getDataFine(), formatter);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error while parsing the data string"));
        }

            // Crea un oggetto attività da activityRequest
            Activity activity = new Activity(
                    activityRequest.getNome(),
                    activityRequest.getDescrizione(),
                    dataInizio,
                    dataFine,
                    activityRequest.getLatitudine(),
                    activityRequest.getLongitudine(),
                    activityRequest.getTipo(),
                    activityRequest.getMax_partecipanti()
            );

            System.out.println("date:" +dataInizio);

            // Andiamo a salvare il nostro oggetto nel DB
            try {
                Activity savedActivity = activityRepository.save(activity);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error storing data in the database"));
            }

            //TODO: qua non uso ancora ActivityResponse, dato che sto salvando un oggetto nel DB e non mi serve restituire un dato, ma un messaggio
            return ResponseEntity.ok(new MessageResponse("Activity added successfully"));

        }
}
