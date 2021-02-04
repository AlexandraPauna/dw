package com.dw.dw.service.impl;

import com.dw.dw.model.Judet;
import com.dw.dw.repository.JudetRepository;
import com.dw.dw.service.JudetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JudetServiceImpl implements JudetService {
    private final JudetRepository judetRepository;

    @Autowired
    public JudetServiceImpl(JudetRepository judetRepository) {
        this.judetRepository = judetRepository;
    }

    @Override
    public Judet findJudetById(Integer id) {
        Optional<Judet> judetOptional = judetRepository.findById(id);

        if (!judetOptional.isPresent()) {
            throw new RuntimeException("Judet not found!");
        }

        return judetOptional.get();
    }
}
