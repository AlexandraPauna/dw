package com.dw.dw.repository.rural;

import com.dw.dw.model.rural.ClasaRural;
import com.dw.dw.model.rural.InstitutieInvatamantRural;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClasaRuralRepository extends JpaRepository<ClasaRural, Integer> {
    Optional<ClasaRural> findByNume(String nume);
    List<ClasaRural> findByInstitutie(InstitutieInvatamantRural institutieInvatamant);
}
