package com.dw.dw.repository;

import com.dw.dw.model.InstitutieInvatamant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstitutieInvatamantRepository extends JpaRepository<InstitutieInvatamant, Integer> {
    Optional<InstitutieInvatamant> findByNume(String nume);
}
