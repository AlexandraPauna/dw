package com.dw.dw.repository;

import com.dw.dw.model.Clasa;
import com.dw.dw.model.Elev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElevRepository extends JpaRepository<Elev, Integer> {
    Optional<Elev> findByNume(String nume);
}
