package com.dw.dw.service.impl;

import com.dw.dw.model.Regiune;
import com.dw.dw.model.TipZona;
import com.dw.dw.repository.RegiuneRepository;
import com.dw.dw.service.RegiuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegiuneServiceImpl implements RegiuneService {
    private final RegiuneRepository regiuneRepository;

    @Autowired
    public RegiuneServiceImpl(RegiuneRepository regiuneRepository) {
        this.regiuneRepository = regiuneRepository;
    }

    @Override
    public List<Regiune> getAllRegiune() {
        return regiuneRepository.findAll();
    }

    @Override
    public Regiune findRegiuneById(Integer id) {
        Optional<Regiune> regiuneOptional = regiuneRepository.findById(id);

        if (!regiuneOptional.isPresent()) {
            throw new RuntimeException("Regiune not found!");
        }

        return regiuneOptional.get();
    }
}
