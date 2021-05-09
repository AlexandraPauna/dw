package com.dw.dw.repository.centralizat;

import com.dw.dw.model.centralizat.InstitutieInvatamant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstitutieInvatamantRepository extends JpaRepository<InstitutieInvatamant, Integer> {
    Optional<InstitutieInvatamant> findByNume(String nume);
}
