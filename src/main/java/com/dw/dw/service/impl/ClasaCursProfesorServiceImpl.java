package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.ClasaCursProfesor;
import com.dw.dw.repository.centralizat.ClasaCursProfesorRepository;
import com.dw.dw.service.ClasaCursProfesorService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasaCursProfesorServiceImpl implements ClasaCursProfesorService {
    private final ClasaCursProfesorRepository clasaCursProfesorRepository;

    @Autowired
    public ClasaCursProfesorServiceImpl(ClasaCursProfesorRepository clasaCursProfesorRepository) {
        this.clasaCursProfesorRepository = clasaCursProfesorRepository;
    }

    @Override
    public List<ClasaCursProfesor> getAllClasaCursProfesor() {

        return clasaCursProfesorRepository.findAll();
    }

    @Override
    public ClasaCursProfesor findById(int id) {
        Optional<ClasaCursProfesor> elemOptional = clasaCursProfesorRepository.findById(id);

        if (elemOptional.isPresent())
            return elemOptional.get();
        else
            throw new ResourceNotFoundException("ClasaCursProfesor " + id + " not found");
    }

    @Override
    public ClasaCursProfesor saveClasaCursProfesor(ClasaCursProfesor elem) {
        return clasaCursProfesorRepository.saveAndFlush(elem);
    }

    @Override
    public void deleteById(int id) {
        clasaCursProfesorRepository.deleteById(id);
    }

    @Override
    public ClasaCursProfesor findClasaCursProfesorById(Integer id) {
        Optional<ClasaCursProfesor> elemOptional = clasaCursProfesorRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("ClasaCursProfesor negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public ClasaCursProfesor updateClasaCursProfesor(ClasaCursProfesor clasa) {
        return clasaCursProfesorRepository.save(clasa);
    }
}
