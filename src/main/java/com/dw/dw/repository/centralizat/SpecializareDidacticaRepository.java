package com.dw.dw.repository.centralizat;

import com.dw.dw.model.centralizat.SpecializareDidactica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializareDidacticaRepository extends JpaRepository<SpecializareDidactica, Integer> {
    List<SpecializareDidactica> findByProfesori_id(Integer profesorId);
}
