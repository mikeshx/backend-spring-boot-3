package com.bezkoder.spring.login.repository;

import java.util.Optional;

import com.bezkoder.spring.login.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.login.models.Role;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
