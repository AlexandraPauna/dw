package com.dw.dw.service;

import com.dw.dw.model.centralizat.TipInstitutie;

import java.util.List;

public interface TipInstitutieService {
    List<TipInstitutie> getAllTipInstitutie();
    //public TipInstitutie findById(int id);
    TipInstitutie saveTipInstitutie(TipInstitutie tipInstitutie);
    void deleteById(int id);
    TipInstitutie findTipInstitutieById(Integer id);
    TipInstitutie updateTipInstitutie(TipInstitutie tipInstitutie);
}
