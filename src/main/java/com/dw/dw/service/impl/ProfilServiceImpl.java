package com.dw.dw.service.impl;

import com.dw.dw.model.Profil;
import com.dw.dw.model.TipZona;
import com.dw.dw.repository.ProfilRepository;
import com.dw.dw.repository.TipZonaRepository;
import com.dw.dw.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilServiceImpl implements ProfilService {
    private final ProfilRepository profilRepository;

    @Autowired
    public ProfilServiceImpl(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

    @Override
    public List<Profil> getAllProfil() {
        return profilRepository.findAll();
    }

    @Override
    public Profil findProfilById(Integer id) {
        Optional<Profil> elemOptional = profilRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Profil not found!");
        }

        return elemOptional.get();
    }
}
