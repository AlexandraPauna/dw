package com.dw.dw.repository.rural;


import com.dw.dw.model.rural.ElevRural;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElevRuralRepository extends JpaRepository<ElevRural, Integer> {
    Optional<ElevRural> findByNume(String nume);
}
