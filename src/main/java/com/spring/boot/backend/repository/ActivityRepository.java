package com.spring.boot.backend.repository;

import java.util.List;

import com.spring.boot.backend.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    // Restituisce tutte le attività organizzate da un utente
    // SELECT * FROM Activity WHERE id_organizzatore = 1;
    List<Activity> findByOrganizzatoreId(Long organizzatoreId);

    List<Activity> findByLatitudineBetweenAndLongitudineBetween(Double minLat, Double maxLat, Double minLng, Double maxLng);
}
