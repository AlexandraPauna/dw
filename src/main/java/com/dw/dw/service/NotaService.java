package com.dw.dw.service;

import com.dw.dw.model.centralizat.Nota;
import com.dw.dw.model.rural.NotaRural;
import com.dw.dw.model.urban.NotaUrban;

import java.util.List;

public interface NotaService {
    List<Nota> getAllNote();
    Nota saveNota(Nota nota);
    void deleteById(int id);
    Nota findNotaById(Integer id);
    Nota updateNota(Nota nota);

    NotaUrban saveNotaUrban(NotaUrban nota);
    void deleteByIdUrban(int id);
    NotaUrban findNotaByIdUrban(Integer id);
    NotaUrban updateNotaUrban(NotaUrban nota);

    NotaRural saveNotaRural(NotaRural nota);
    void deleteByIdRural(int id);
    NotaRural findNotaByIdRural(Integer id);
    NotaRural updateNotaRural(NotaRural nota);
}
