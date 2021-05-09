package com.dw.dw.service;

import com.dw.dw.model.centralizat.Clasa;
import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.urban.ClasaUrban;

import java.util.List;

public interface ClasaService {
    List<Clasa> getAllClasa();
    public Clasa findById(int id);
    Clasa saveClasa(Clasa clasa);
    void deleteById(int id);
    Clasa findClasaById(Integer id);
    Clasa updateClasa(Clasa clasa);
    List<Clasa> getAllClasaForInstitutieInvatamant(InstitutieInvatamant institutieInvatamant);

    ClasaUrban saveClasaUrban(ClasaUrban clasa);
}
