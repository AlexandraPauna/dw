package com.dw.dw.service;

import com.dw.dw.model.centralizat.Nota;

import java.util.List;

public interface NotaService {
    List<Nota> getAllNote();
    Nota saveNota(Nota nota);
    void deleteById(int id);
    Nota findNotaById(Integer id);
    Nota updateNota(Nota nota);
}
