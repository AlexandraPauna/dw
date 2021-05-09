package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Elev;
import com.dw.dw.model.urban.ElevUrban;
import com.dw.dw.repository.centralizat.ElevRepository;
import com.dw.dw.repository.urban.ElevUrbanRepository;
import com.dw.dw.service.ElevService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElevServiceImpl implements ElevService {
    private final ElevRepository elevRepository;

    private final ElevUrbanRepository elevUrbanRepository;

    @Autowired
    public ElevServiceImpl(ElevRepository elevRepository, ElevUrbanRepository elevUrbanRepository) {
        this.elevRepository = elevRepository;
        this.elevUrbanRepository = elevUrbanRepository;
    }

    @Override
    public List<Elev> getAllElev() {

        return elevRepository.findAll();
    }

    @Override
    public Elev findById(int id) {
        Optional<Elev> elemOptional = elevRepository.findById(id);

        if (elemOptional.isPresent())
            return elemOptional.get();
        else
            throw new ResourceNotFoundException("Elev " + id + " not found");
    }

    @Override
    public Elev saveElev(Elev elev) {
        return elevRepository.saveAndFlush(elev);
    }

    @Override
    public void deleteById(int id) {
        elevRepository.deleteById(id);
    }

    @Override
    public Elev findElevById(Integer id) {
        Optional<Elev> elemOptional = elevRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Elev negasit!");
        }

        return elemOptional.get();
    }

    @Override
    public Elev updateElev(Elev elev) {
        return elevRepository.save(elev);
    }

    @Override
    public ElevUrban saveElevUrban(ElevUrban elev) {
        return elevUrbanRepository.saveAndFlush(elev);
    }
}
