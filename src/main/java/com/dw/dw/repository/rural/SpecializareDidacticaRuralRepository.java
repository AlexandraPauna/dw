package com.dw.dw.repository.rural;

import com.dw.dw.model.rural.SpecializareDidactica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializareDidacticaRuralRepository extends JpaRepository<SpecializareDidactica, Integer> {
    List<SpecializareDidactica> findByProfesori_id(Integer profesorId);
}
