package com.dw.dw.service.impl;

import com.dw.dw.model.TipInstitutie;
import com.dw.dw.repository.InstitutieInvatamantRepository;
import com.dw.dw.repository.TipInstitutieRepository;
import com.dw.dw.service.TipInstitutieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipInstitutieServiceImpl implements TipInstitutieService {
    private final TipInstitutieRepository tipInstitutieRepository;

    @Autowired
    public TipInstitutieServiceImpl(TipInstitutieRepository tipInstitutieRepository) {
        this.tipInstitutieRepository = tipInstitutieRepository;
    }

    @Override
    public List<TipInstitutie> getAllTipInstitutie() {
        return tipInstitutieRepository.findAll();
    }

    @Override
    public TipInstitutie saveTipInstitutie(TipInstitutie tipInstitutie) {
        return tipInstitutieRepository.saveAndFlush(tipInstitutie);
    }

    @Override
    public void deleteById(int id) {
        tipInstitutieRepository.deleteById(id);
    }

    @Override
    public TipInstitutie findTipInstitutieById(Integer id) {
        Optional<TipInstitutie> tipInstitutieOptional = tipInstitutieRepository.findById(id);

        if (!tipInstitutieOptional.isPresent()) {
            throw new RuntimeException("Tip Institutie nu a fost gasit!");
        }

        return tipInstitutieOptional.get();
    }

    @Override
    public TipInstitutie updateTipInstitutie(TipInstitutie tipInstitutie) {
        return tipInstitutieRepository.saveAndFlush(tipInstitutie);
    }
}
