package com.dw.dw.repository;

import com.dw.dw.model.Profil;
import com.dw.dw.model.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecializareRepository extends JpaRepository<Specializare, Integer> {
    Optional<Specializare> findByDenumire(String denumire);
    List<Specializare> findByProfil(Profil profil);
}
