package com.dw.dw.repository.urban;

import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.urban.InstitutieInvatamantUrban;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstitutieInvatamantUrbanRepository extends JpaRepository<InstitutieInvatamantUrban, Integer> {
    Optional<InstitutieInvatamantUrban> findByNume(String nume);
}
