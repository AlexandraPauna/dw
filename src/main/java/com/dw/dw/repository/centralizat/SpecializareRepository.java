package com.dw.dw.repository.centralizat;

import com.dw.dw.model.centralizat.Profil;
import com.dw.dw.model.centralizat.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecializareRepository extends JpaRepository<Specializare, Integer> {
    Optional<Specializare> findByDenumire(String denumire);
    List<Specializare> findByProfil(Profil profil);
}
