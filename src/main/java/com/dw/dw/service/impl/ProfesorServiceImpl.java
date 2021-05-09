package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Profesor;
import com.dw.dw.model.urban.ProfesorUrban;
import com.dw.dw.repository.centralizat.ProfesorRepository;
import com.dw.dw.repository.urban.ProfesorUrbanRepository;
import com.dw.dw.service.ProfesorService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final ProfesorUrbanRepository profesorUrbanRepository;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, ProfesorUrbanRepository profesorUrbanRepository) {
        this.profesorRepository = profesorRepository;
        this.profesorUrbanRepository = profesorUrbanRepository;
    }

    @Override
    public List<Profesor> getAllProfesor() {

        return profesorRepository.findAll();
    }

    @Override
    public Profesor findById(int id) {
        Optional<Profesor> elemOptional = profesorRepository.findById(id);

        if (elemOptional.isPresent())
            return elemOptional.get();
        else
            throw new ResourceNotFoundException("Profesor " + id + " not found");
    }

    @Override
    public Profesor saveProfesor(Profesor profesor) {
        return profesorRepository.saveAndFlush(profesor);
    }

    @Override
    public void deleteById(int id) {
        profesorRepository.deleteById(id);
    }

    @Override
    public Profesor findProfesorById(Integer id) {
        Optional<Profesor> elemOptional = profesorRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Profesor negasit!");
        }

        return elemOptional.get();
    }

    @Override
    public Profesor updateProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public ProfesorUrban saveProfesorUrban(ProfesorUrban profesor) {
        return profesorUrbanRepository.saveAndFlush(profesor);
    }

}
