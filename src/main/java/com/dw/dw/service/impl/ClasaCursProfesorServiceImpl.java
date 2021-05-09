package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.ClasaCursProfesor;
import com.dw.dw.model.rural.ClasaCursProfesorRural;
import com.dw.dw.model.urban.ClasaCursProfesorUrban;
import com.dw.dw.repository.centralizat.ClasaCursProfesorRepository;
import com.dw.dw.repository.rural.ClasaCursProfesorRuralRepository;
import com.dw.dw.repository.urban.ClasaCursProfesorUrbanRepository;
import com.dw.dw.service.ClasaCursProfesorService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasaCursProfesorServiceImpl implements ClasaCursProfesorService {
    private final ClasaCursProfesorRepository clasaCursProfesorRepository;
    private final ClasaCursProfesorUrbanRepository clasaCursProfesorUrbanRepository;
    private final ClasaCursProfesorRuralRepository clasaCursProfesorRuralRepository;

    @Autowired
    public ClasaCursProfesorServiceImpl(ClasaCursProfesorRepository clasaCursProfesorRepository, ClasaCursProfesorUrbanRepository clasaCursProfesorUrbanRepository, ClasaCursProfesorRuralRepository clasaCursProfesorRuralRepository) {
        this.clasaCursProfesorRepository = clasaCursProfesorRepository;
        this.clasaCursProfesorUrbanRepository = clasaCursProfesorUrbanRepository;
        this.clasaCursProfesorRuralRepository = clasaCursProfesorRuralRepository;
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

    //URBAN
    @Override
    public ClasaCursProfesorUrban saveClasaCursProfesorUrban(ClasaCursProfesorUrban elem) {
        return clasaCursProfesorUrbanRepository.saveAndFlush(elem);
    }

    @Override
    public ClasaCursProfesorUrban updateClasaCursProfesorUrban(ClasaCursProfesorUrban clasa) {
        return clasaCursProfesorUrbanRepository.save(clasa);
    }

    @Override
    public void deleteByIdUrban(int id) {
        clasaCursProfesorUrbanRepository.deleteById(id);
    }

    @Override
    public ClasaCursProfesorUrban findClasaCursProfesorUrbanById(Integer id) {
        Optional<ClasaCursProfesorUrban> elemOptional = clasaCursProfesorUrbanRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("ClasaCursProfesorUrban negasita!");
        }

        return elemOptional.get();
    }

    //RURAL
    @Override
    public ClasaCursProfesorRural saveClasaCursProfesorRural(ClasaCursProfesorRural elem) {
        return clasaCursProfesorRuralRepository.saveAndFlush(elem);
    }

    @Override
    public ClasaCursProfesorRural updateClasaCursProfesorRural(ClasaCursProfesorRural clasa) {
        return clasaCursProfesorRuralRepository.save(clasa);
    }

    @Override
    public void deleteByIdRural(int id) {
        clasaCursProfesorRuralRepository.deleteById(id);
    }

    @Override
    public ClasaCursProfesorRural findClasaCursProfesorRuralById(Integer id) {
        Optional<ClasaCursProfesorRural> elemOptional = clasaCursProfesorRuralRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("ClasaCursProfesorRural negasita!");
        }

        return elemOptional.get();
    }
}
