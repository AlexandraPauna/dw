package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Profesor;
import com.dw.dw.model.rural.ProfesorRural;
import com.dw.dw.model.urban.ProfesorUrban;
import com.dw.dw.repository.centralizat.ProfesorRepository;
import com.dw.dw.repository.rural.ProfesorRuralRepository;
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
    private final ProfesorRuralRepository profesorRuralRepository;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, ProfesorUrbanRepository profesorUrbanRepository, ProfesorRuralRepository profesorRuralRepository) {
        this.profesorRepository = profesorRepository;
        this.profesorUrbanRepository = profesorUrbanRepository;
        this.profesorRuralRepository = profesorRuralRepository;
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

    //URBAN
    @Override
    public ProfesorUrban saveProfesorUrban(ProfesorUrban profesor) {
        return profesorUrbanRepository.saveAndFlush(profesor);
    }

    @Override
    public ProfesorUrban findProfesorByIdUrban(Integer id) {
        Optional<ProfesorUrban> elemOptional = profesorUrbanRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("ProfesorUrban negasit!");
        }

        return elemOptional.get();
    }

    @Override
    public ProfesorUrban updateProfesorUrban(ProfesorUrban profesor) {
        return profesorUrbanRepository.save(profesor);
    }

    @Override
    public void deleteByIdUrban(int id) {
        profesorUrbanRepository.deleteById(id);
    }

    //RURAL
    @Override
    public ProfesorRural saveProfesorRural(ProfesorRural profesor) {
        return profesorRuralRepository.saveAndFlush(profesor);
    }

    @Override
    public ProfesorRural findProfesorByIdRural(Integer id) {
        Optional<ProfesorRural> elemOptional = profesorRuralRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("ProfesorRural negasit!");
        }

        return elemOptional.get();
    }

    @Override
    public ProfesorRural updateProfesorRural(ProfesorRural profesor) {
        return profesorRuralRepository.save(profesor);
    }

    @Override
    public void deleteByIdRural(int id) {
        profesorRuralRepository.deleteById(id);
    }
}
