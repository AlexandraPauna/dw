package com.dw.dw.service;

import com.dw.dw.model.SpecializareDidactica;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpecializareDidacticaService {
    List<SpecializareDidactica> getAllSpecializareDidactica();
    public SpecializareDidactica findById(int id);
    SpecializareDidactica saveSpecializareDidactica(SpecializareDidactica specializareDidactica);
    void deleteById(int id);
    SpecializareDidactica findSpecializareDidacticaById(Integer id);
    SpecializareDidactica updateSpecializareDidactica(SpecializareDidactica specializareDidactica);
    List<SpecializareDidactica> getAllSpecializareDidacticaByProfesor(Integer profesorId);
}
