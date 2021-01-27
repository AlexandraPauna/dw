package com.dw.dw.repository;

import com.dw.dw.model.Curs;
import com.dw.dw.model.Elev;
import com.dw.dw.model.InstitutieInvatamant;
import com.dw.dw.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
    Optional<Nota> findByElev(Elev elev);
    Optional<Nota> findByCurs(Curs curs);
}
