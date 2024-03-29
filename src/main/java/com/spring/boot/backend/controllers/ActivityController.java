package com.spring.boot.backend.controllers;

import com.spring.boot.backend.models.User;
import com.spring.boot.backend.repository.ActivityRepository;
import com.spring.boot.backend.models.Activity;
import com.spring.boot.backend.payload.request.ActivityRequest;
import com.spring.boot.backend.payload.response.MessageResponse;
import com.spring.boot.backend.repository.UserRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost:8081", "http://localhost:8100"}, allowCredentials = "true", allowedHeaders = "*")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost:8081", "http://localhost:8100", "http://10.0.2.16", "http://10.0.2.16:8000/", "http://10.0.2.2:8000/", "http://10.0.2.2:8080/", "http://localhost", "http://localhost/*", "http://localhost/register"}, allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/api/activity")

public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRepository userRepository;

    /** API endpoint per la creaizone di una attività */

    //TODO: proteggi richiesta POST con auth
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

        User organizzatore = userRepository.findById(activityRequest.getId_organizzatore())

                .orElseThrow(() -> new RuntimeException("Organizzatore non trovato"));
        System.out.println("id_organizzatore:" +activityRequest.getId_organizzatore());
        System.out.println("nome tipo evento:" +activityRequest.getNome_tipo_evento());

            // Crea un oggetto attività da activityRequest
            Activity activity = new Activity(
                    activityRequest.getNome(),
                    organizzatore,
                    activityRequest.getNome_tipo_evento(),
                    activityRequest.getDescrizione(),
                    dataInizio,
                    dataFine,
                    activityRequest.getLatitudine(),
                    activityRequest.getLongitudine(),
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

    //TODO: proteggi richiesta POST con auth
    @PostMapping("/getActivitiesByBounds")
    public ResponseEntity<?> getActivitiesByBounds(@Valid @RequestBody Map<String, Double> coordinates, BindingResult bindingResult) {
        Double northEastLat = coordinates.get("northEastLat");
        Double northEastLng = coordinates.get("northEastLng");
        Double southWestLat = coordinates.get("southWestLat");
        Double southWestLng = coordinates.get("southWestLng");

        List<Activity> activities = activityRepository.findByLatitudineBetweenAndLongitudineBetween(southWestLat, northEastLat, southWestLng, northEastLng);
        System.out.println("Numero di attività trovate: " + activities.size());

        // Ora puoi fare ciò che vuoi con le coordinate ricevute
        return ResponseEntity.ok(activities);
    }
}