package com.dw.dw.repository.rural;

import com.dw.dw.model.rural.InstitutieInvatamantRural;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstitutieInvatamantRuralRepository extends JpaRepository<InstitutieInvatamantRural, Integer> {
    Optional<InstitutieInvatamantRural> findByNume(String nume);
}
