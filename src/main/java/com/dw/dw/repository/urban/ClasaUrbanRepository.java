package com.dw.dw.repository.urban;

import com.dw.dw.model.centralizat.Clasa;
import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.urban.ClasaUrban;
import com.dw.dw.model.urban.InstitutieInvatamantUrban;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClasaUrbanRepository extends JpaRepository<ClasaUrban, Integer> {
    Optional<ClasaUrban> findByNume(String nume);
    List<ClasaUrban> findByInstitutie(InstitutieInvatamantUrban institutieInvatamant);
}
