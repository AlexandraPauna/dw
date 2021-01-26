package com.dw.dw.service;

import com.dw.dw.model.Curs;

import java.util.List;

public interface CursService {
    List<Curs> getAllCurs();
    public Curs findById(int id);
    Curs saveCurs(Curs curs);
    void deleteById(int id);
    Curs findCursById(Integer id);
    Curs updateCurs(Curs curs);
}
