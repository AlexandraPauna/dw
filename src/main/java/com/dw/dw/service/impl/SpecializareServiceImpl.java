package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Profil;
import com.dw.dw.model.centralizat.Specializare;
import com.dw.dw.repository.centralizat.SpecializareRepository;
import com.dw.dw.service.SpecializareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializareServiceImpl implements SpecializareService {
    private final SpecializareRepository specializareRepository;

    @Autowired
    public SpecializareServiceImpl(SpecializareRepository specializareRepository) {
        this.specializareRepository = specializareRepository;
    }

    @Override
    public List<Specializare> getAllSpecializare() {
        return specializareRepository.findAll();
    }

    @Override
    public Specializare findSpecializareById(Integer id) {
        Optional<Specializare> elemOptional = specializareRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Specializare not found!");
        }

        return elemOptional.get();
    }

    @Override
    public List<Specializare> getAllSpecializareForProfil(Profil profil) {
        return specializareRepository.findByProfil(profil);
    }
}
