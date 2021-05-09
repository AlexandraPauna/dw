package com.dw.dw.repository.centralizat;

import com.dw.dw.model.centralizat.Elev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElevRepository extends JpaRepository<Elev, Integer> {
    Optional<Elev> findByNume(String nume);
}
