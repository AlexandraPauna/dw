package com.dw.dw.service;

import com.dw.dw.model.centralizat.Profil;
import com.dw.dw.model.centralizat.Specializare;

import java.util.List;

public interface SpecializareService {
    List<Specializare> getAllSpecializare();
    Specializare findSpecializareById(Integer id);
    List<Specializare> getAllSpecializareForProfil(Profil profil);
}
