package com.dw.dw.repository.rural;

import com.dw.dw.model.rural.Profil;
import com.dw.dw.model.rural.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecializareRuralRepository extends JpaRepository<Specializare, Integer> {
    Optional<Specializare> findByDenumire(String denumire);
    List<Specializare> findByProfil(Profil profil);
}
