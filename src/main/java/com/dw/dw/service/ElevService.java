package com.dw.dw.service;

import com.dw.dw.model.centralizat.Elev;

import java.util.List;

public interface ElevService {
    List<Elev> getAllElev();
    public Elev findById(int id);
    Elev saveElev(Elev elev);
    void deleteById(int id);
    Elev findElevById(Integer id);
    Elev updateElev(Elev elev);
}
