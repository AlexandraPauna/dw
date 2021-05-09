package com.dw.dw.repository.centralizat;

import com.dw.dw.model.centralizat.Curs;
import com.dw.dw.model.centralizat.Elev;
import com.dw.dw.model.centralizat.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
    Optional<Nota> findByElev(Elev elev);
    Optional<Nota> findByCurs(Curs curs);
}
