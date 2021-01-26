package com.dw.dw.service.impl;

import com.dw.dw.model.Clasa;
import com.dw.dw.model.InstitutieInvatamant;
import com.dw.dw.repository.ClasaRepository;
import com.dw.dw.repository.InstitutieInvatamantRepository;
import com.dw.dw.service.ClasaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasaServiceImpl implements ClasaService {
    private final ClasaRepository clasaRepository;

    @Autowired
    public ClasaServiceImpl(ClasaRepository clasaRepository) {
        this.clasaRepository = clasaRepository;
    }

    @Override
    public List<Clasa> getAllClasa() {

        return clasaRepository.findAll();
    }

    @Override
    public Clasa findById(int id) {
        Optional<Clasa> elemOptional = clasaRepository.findById(id);

        if (elemOptional.isPresent())
            return elemOptional.get();
        else
            throw new ResourceNotFoundException("Clasa " + id + " not found");
    }

    @Override
    public Clasa saveClasa(Clasa clasa) {
        return clasaRepository.saveAndFlush(clasa);
    }

    @Override
    public void deleteById(int id) {
        clasaRepository.deleteById(id);
    }

    @Override
    public Clasa findClasaById(Integer id) {
        Optional<Clasa> elemOptional = clasaRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Clasa negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public Clasa updateClasa(Clasa clasa) {
        return clasaRepository.save(clasa);
    }

    @Override
    public List<Clasa> getAllClasaForInstitutieInvatamant(InstitutieInvatamant institutieInvatamant) {
        return clasaRepository.findByInstitutie(institutieInvatamant);
    }
}
