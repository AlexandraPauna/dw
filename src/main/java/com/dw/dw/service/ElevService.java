package com.dw.dw.service;

import com.dw.dw.model.centralizat.Elev;
import com.dw.dw.model.rural.ElevRural;
import com.dw.dw.model.urban.ElevUrban;

import java.util.List;

public interface ElevService {
    List<Elev> getAllElev();
    public Elev findById(int id);
    Elev saveElev(Elev elev);
    void deleteById(int id);
    Elev findElevById(Integer id);
    Elev updateElev(Elev elev);

    ElevUrban saveElevUrban(ElevUrban elev);
    void deleteByIdUrban(int id);
    ElevUrban findElevUrbanById(Integer id);
    ElevUrban updateElevUrban(ElevUrban elev);

    ElevRural saveElevRural(ElevRural elev);
    void deleteByIdRural(int id);
    ElevRural findElevRuralById(Integer id);
    ElevRural updateElevRural(ElevRural elev);
}
