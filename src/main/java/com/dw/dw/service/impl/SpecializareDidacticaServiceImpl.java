package com.dw.dw.service.impl;

import com.dw.dw.model.SpecializareDidactica;
import com.dw.dw.repository.SpecializareDidacticaRepository;
import com.dw.dw.service.SpecializareDidacticaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializareDidacticaServiceImpl implements SpecializareDidacticaService {
    private final SpecializareDidacticaRepository specializareDidacticaRepository;

    @Autowired
    public SpecializareDidacticaServiceImpl(SpecializareDidacticaRepository specializareDidacticaRepository) {
        this.specializareDidacticaRepository = specializareDidacticaRepository;
    }

    @Override
    public List<SpecializareDidactica> getAllSpecializareDidactica() {

        return specializareDidacticaRepository.findAll();
    }

    @Override
    public SpecializareDidactica findById(int id) {
        Optional<SpecializareDidactica> elemOptional = specializareDidacticaRepository.findById(id);

        if (elemOptional.isPresent())
            return elemOptional.get();
        else
            throw new ResourceNotFoundException("Specializare Didactica " + id + " not found");
    }

    @Override
    public SpecializareDidactica saveSpecializareDidactica(SpecializareDidactica specializareDidactica) {
        return specializareDidacticaRepository.saveAndFlush(specializareDidactica);
    }

    @Override
    public void deleteById(int id) {
        specializareDidacticaRepository.deleteById(id);
    }

    @Override
    public SpecializareDidactica findSpecializareDidacticaById(Integer id) {
        Optional<SpecializareDidactica> elemOptional = specializareDidacticaRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Specializare Didactica negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public SpecializareDidactica updateSpecializareDidactica(SpecializareDidactica specializareDidactica) {
        return specializareDidacticaRepository.save(specializareDidactica);
    }

    @Override
    public List<SpecializareDidactica> getAllSpecializareDidacticaByProfesor(Integer profesorId) {

        return specializareDidacticaRepository.findByProfesori_id(profesorId);
    }
}
