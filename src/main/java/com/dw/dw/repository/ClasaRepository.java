package com.dw.dw.repository;

import com.dw.dw.model.Clasa;
import com.dw.dw.model.InstitutieInvatamant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasaRepository extends JpaRepository<Clasa, Integer> {
    Optional<Clasa> findByNume(String nume);
}
