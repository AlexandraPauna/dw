package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Curs;
import com.dw.dw.repository.centralizat.CursRepository;
import com.dw.dw.service.CursService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursServiceImpl implements CursService {
    private final CursRepository cursRepository;

    @Autowired
    public CursServiceImpl(CursRepository cursRepository) {
        this.cursRepository = cursRepository;
    }

    @Override
    public List<Curs> getAllCurs() {

        return cursRepository.findAll();
    }

    @Override
    public Curs findById(int id) {
        Optional<Curs> elemOptional = cursRepository.findById(id);

        if (elemOptional.isPresent())
            return elemOptional.get();
        else
            throw new ResourceNotFoundException("Curs " + id + " not found");
    }

    @Override
    public Curs saveCurs(Curs curs) {
        return cursRepository.saveAndFlush(curs);
    }

    @Override
    public void deleteById(int id) {
        cursRepository.deleteById(id);
    }

    @Override
    public Curs findCursById(Integer id) {
        Optional<Curs> elemOptional = cursRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Curs negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public Curs updateCurs(Curs clasa) {
        return cursRepository.save(clasa);
    }
}
