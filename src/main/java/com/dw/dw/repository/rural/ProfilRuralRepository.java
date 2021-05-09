package com.dw.dw.repository.rural;

import com.dw.dw.model.rural.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilRuralRepository extends JpaRepository<Profil, Integer> {
    Optional<Profil> findByDenumire(String denumire);
}
