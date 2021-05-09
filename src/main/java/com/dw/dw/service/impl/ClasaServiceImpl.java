package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Clasa;
import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.urban.ClasaUrban;
import com.dw.dw.repository.centralizat.ClasaRepository;
import com.dw.dw.repository.urban.ClasaUrbanRepository;
import com.dw.dw.service.ClasaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasaServiceImpl implements ClasaService {
    private final ClasaRepository clasaRepository;

    private final ClasaUrbanRepository clasaUrbanRepository;

    @Autowired
    public ClasaServiceImpl(ClasaRepository clasaRepository, ClasaUrbanRepository clasaUrbanRepository) {
        this.clasaRepository = clasaRepository;
        this.clasaUrbanRepository = clasaUrbanRepository;
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

    //URBAN
    @Override
    public List<Clasa> getAllClasaForInstitutieInvatamant(InstitutieInvatamant institutieInvatamant) {
        return clasaRepository.findByInstitutie(institutieInvatamant);
    }

    @Override
    public ClasaUrban saveClasaUrban(ClasaUrban clasa) {
        return clasaUrbanRepository.saveAndFlush(clasa);
    }

    @Override
    public void deleteByIdUrban(int id) {
        clasaUrbanRepository.deleteById(id);
    }

    @Override
    public ClasaUrban findClasaUrbanById(Integer id) {
        Optional<ClasaUrban> elemOptional = clasaUrbanRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("ClasaUrban negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public ClasaUrban updateClasaUrban(ClasaUrban clasa) {
        return clasaUrbanRepository.save(clasa);
    }
}
