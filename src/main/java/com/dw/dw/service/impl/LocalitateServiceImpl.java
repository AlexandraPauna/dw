package com.dw.dw.service.impl;

import com.dw.dw.model.Localitate;
import com.dw.dw.repository.LocalitateRepository;
import com.dw.dw.service.LocalitateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalitateServiceImpl implements LocalitateService {
    private final LocalitateRepository localitateRepository;

    @Autowired
    public LocalitateServiceImpl(LocalitateRepository localitateRepository) {
        this.localitateRepository = localitateRepository;
    }

    @Override
    public List<Localitate> getAllLocalitate() {
        return localitateRepository.findAll();
    }

    @Override
    public Localitate saveLocalitate(Localitate localitate) {
        return localitateRepository.saveAndFlush(localitate);
    }

    @Override
    public void deleteById(int id) {
        localitateRepository.deleteById(id);
    }

    @Override
    public Localitate findLocalitateById(Integer id) {
        Optional<Localitate> recipeOptional = localitateRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Localitate not found!");
        }

        return recipeOptional.get();
    }

    @Override
    public Localitate updateLocalitate(Localitate localitate) {
        return localitateRepository.saveAndFlush(localitate);
    }
}
