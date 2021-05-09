package com.dw.dw.repository.urban;

import com.dw.dw.model.centralizat.Clasa;
import com.dw.dw.model.centralizat.InstitutieInvatamant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClasaUrbanRepository extends JpaRepository<Clasa, Integer> {
    Optional<Clasa> findByNume(String nume);
    List<Clasa> findByInstitutie(InstitutieInvatamant institutieInvatamant);
}
