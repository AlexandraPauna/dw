package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Subregiune;
import com.dw.dw.repository.centralizat.SubregiuneRepository;
import com.dw.dw.service.SubregiuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubregiuneServiceImpl implements SubregiuneService {
    private final SubregiuneRepository subregiuneRepository;

    @Autowired
    public SubregiuneServiceImpl(SubregiuneRepository subregiuneRepository) {
        this.subregiuneRepository = subregiuneRepository;
    }

    @Override
    public List<Subregiune> getAllSubregiune() {
        return subregiuneRepository.findAll();
    }

    @Override
    public Subregiune findSubregiuneById(Integer id) {
        Optional<Subregiune> subregiuneOptional = subregiuneRepository.findById(id);

        if (!subregiuneOptional.isPresent()) {
            throw new RuntimeException("Subregiune not found!");
        }

        return subregiuneOptional.get();
    }
}
