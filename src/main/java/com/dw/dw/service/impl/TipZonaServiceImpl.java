package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.TipZona;
import com.dw.dw.repository.centralizat.TipZonaRepository;
import com.dw.dw.service.TipZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipZonaServiceImpl implements TipZonaService {
    private final TipZonaRepository tipZonaRepository;

    @Autowired
    public TipZonaServiceImpl(TipZonaRepository tipZonaRepository) {
        this.tipZonaRepository = tipZonaRepository;
    }

    @Override
    public List<TipZona> getAllTipZona() {
        return tipZonaRepository.findAll();
    }

    @Override
    public TipZona findTipZonaById(Integer id) {
        Optional<TipZona> tipZonaOptional = tipZonaRepository.findById(id);

        if (!tipZonaOptional.isPresent()) {
            throw new RuntimeException("Tip Zona not found!");
        }

        return tipZonaOptional.get();
    }
}
