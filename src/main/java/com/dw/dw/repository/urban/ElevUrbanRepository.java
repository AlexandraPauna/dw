package com.dw.dw.repository.urban;

import com.dw.dw.model.urban.ElevUrban;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElevUrbanRepository extends JpaRepository<ElevUrban, Integer> {
    Optional<ElevUrban> findByNume(String nume);
}
