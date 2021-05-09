package com.dw.dw.repository.urban;

import com.dw.dw.model.urban.Curs;
import com.dw.dw.model.urban.ElevUrban;
import com.dw.dw.model.urban.NotaUrban;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotaUrbanRepository extends JpaRepository<NotaUrban, Integer> {
    Optional<NotaUrban> findByElev(ElevUrban elev);
    Optional<NotaUrban> findByCurs(Curs curs);
}
