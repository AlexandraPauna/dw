package com.dw.dw.repository.rural;

import com.dw.dw.model.rural.Curs;
import com.dw.dw.model.rural.ElevRural;
import com.dw.dw.model.rural.NotaRural;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotaRuralRepository extends JpaRepository<NotaRural, Integer> {
    Optional<NotaRural> findByElev(ElevRural elev);
    Optional<NotaRural> findByCurs(Curs curs);
}
