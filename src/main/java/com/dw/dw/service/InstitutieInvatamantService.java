package com.dw.dw.service;

import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.rural.InstitutieInvatamantRural;
import com.dw.dw.model.urban.InstitutieInvatamantUrban;

import java.util.List;

public interface InstitutieInvatamantService {
    List<InstitutieInvatamant> getAllInstitutieInvatamant();
    public InstitutieInvatamant findById(int id);
    InstitutieInvatamant saveInstitutieInvatamant(InstitutieInvatamant institutieInvatamant);
    void deleteById(int id);
    InstitutieInvatamant findInstitutieInvatamantById(Integer id);
    InstitutieInvatamant updateInstitutieInvatamant(InstitutieInvatamant institutieInvatamant);

    InstitutieInvatamantUrban saveInstitutieInvatamant_Urban(InstitutieInvatamantUrban institutieInvatamant);
    void deleteByIdUrban(int id);
    InstitutieInvatamantUrban findInstitutieInvatamantByIdUrban(Integer id);
    InstitutieInvatamantUrban updateInstitutieInvatamantUrban(InstitutieInvatamantUrban institutieInvatamant);

    InstitutieInvatamantRural saveInstitutieInvatamant_Rural(InstitutieInvatamantRural institutieInvatamant);
    void deleteByIdRural(int id);
    InstitutieInvatamantRural findInstitutieInvatamantByIdRural(Integer id);
    InstitutieInvatamantRural updateInstitutieInvatamantRural(InstitutieInvatamantRural institutieInvatamant);
}
