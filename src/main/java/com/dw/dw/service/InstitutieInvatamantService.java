package com.dw.dw.service;

import com.dw.dw.model.centralizat.InstitutieInvatamant;

import java.util.List;

public interface InstitutieInvatamantService {
    List<InstitutieInvatamant> getAllInstitutieInvatamant();
    public InstitutieInvatamant findById(int id);
    InstitutieInvatamant saveInstitutieInvatamant(InstitutieInvatamant institutieInvatamant);
    void deleteById(int id);
    InstitutieInvatamant findInstitutieInvatamantById(Integer id);
    InstitutieInvatamant updateInstitutieInvatamant(InstitutieInvatamant institutieInvatamant);
}
