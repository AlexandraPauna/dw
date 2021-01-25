package com.dw.dw.service;

import com.dw.dw.model.Profil;

import java.util.List;

public interface ProfilService {
    List<Profil> getAllProfil();
    Profil findProfilById(Integer id);
}
