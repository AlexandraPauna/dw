package com.dw.dw.service;

import com.dw.dw.model.Elev;

import java.util.List;

public interface ElevService {
    List<Elev> getAllElev();
    public Elev findById(int id);
    Elev saveElev(Elev elev);
    void deleteById(int id);
    Elev findClasaById(Integer id);
    Elev updateElev(Elev elev);
}
