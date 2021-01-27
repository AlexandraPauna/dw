package com.dw.dw.service.impl;

import com.dw.dw.model.Elev;
import com.dw.dw.model.Nota;
import com.dw.dw.repository.NotaRepository;
import com.dw.dw.repository.ProfesorRepository;
import com.dw.dw.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    public final NotaRepository notaRepository;

    @Autowired
    public NotaServiceImpl(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @Override
    public List<Nota> getAllNote() {
        return notaRepository.findAll();
    }

    @Override
    public Nota saveNota(Nota nota) {
        return notaRepository.save(nota);
    }

}
