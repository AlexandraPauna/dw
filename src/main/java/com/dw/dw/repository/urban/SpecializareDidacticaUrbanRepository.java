package com.dw.dw.repository.urban;

import com.dw.dw.model.urban.SpecializareDidactica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecializareDidacticaUrbanRepository extends JpaRepository<SpecializareDidactica, Integer> {
    List<SpecializareDidactica> findByProfesori_id(Integer profesorId);
}
