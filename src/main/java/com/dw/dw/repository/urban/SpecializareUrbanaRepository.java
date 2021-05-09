package com.dw.dw.repository.urban;

import com.dw.dw.model.urban.Profil;
import com.dw.dw.model.urban.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecializareUrbanaRepository extends JpaRepository<Specializare, Integer> {
    Optional<Specializare> findByDenumire(String denumire);
    List<Specializare> findByProfil(Profil profil);
}
