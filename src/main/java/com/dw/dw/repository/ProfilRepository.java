package com.dw.dw.repository;

import com.dw.dw.model.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilRepository extends JpaRepository<Profil, Integer> {
    Optional<Profil> findByDenumire(String denumire);
}
