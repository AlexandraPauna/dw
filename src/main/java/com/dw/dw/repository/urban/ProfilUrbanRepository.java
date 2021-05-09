package com.dw.dw.repository.urban;

import com.dw.dw.model.urban.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilUrbanRepository extends JpaRepository<Profil, Integer> {
    Optional<Profil> findByDenumire(String denumire);
}
