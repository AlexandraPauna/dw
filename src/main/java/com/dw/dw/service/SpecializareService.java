package com.dw.dw.service;

import com.dw.dw.model.Profil;
import com.dw.dw.model.Specializare;

import java.util.List;

public interface SpecializareService {
    List<Specializare> getAllSpecializare();
    Specializare findSpecializareById(Integer id);
    List<Specializare> getAllSpecializareForProfil(Profil profil);
}
