package com.dw.dw.service;

import com.dw.dw.model.Clasa;
import com.dw.dw.model.InstitutieInvatamant;
import com.dw.dw.model.Nota;

import java.util.List;

public interface NotaService {
    List<Nota> getAllNote();
    Nota saveNota(Nota nota);
}
