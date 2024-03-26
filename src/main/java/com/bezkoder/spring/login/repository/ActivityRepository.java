package com.bezkoder.spring.login.repository;

import java.util.List;
import java.util.Optional;

import com.bezkoder.spring.login.models.Activity;
import com.bezkoder.spring.login.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.login.models.Role;


@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    // Restituisce tutte le attività organizzate da un utente
    // SELECT * FROM Activity WHERE id_organizzatore = 1;
    List<Activity> findByOrganizzatoreId(Long organizzatoreId);

    List<Activity> findByLatitudineBetweenAndLongitudineBetween(Double minLat, Double maxLat, Double minLng, Double maxLng);
}
