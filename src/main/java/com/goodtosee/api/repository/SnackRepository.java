package com.goodtosee.api.repository;

import com.goodtosee.api.entity.Snack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SnackRepository extends JpaRepository<Snack, String> {
    Optional<Snack> findByName(String name);
}