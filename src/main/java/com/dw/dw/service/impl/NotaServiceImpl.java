package com.dw.dw.service.impl;

import com.dw.dw.model.Clasa;
import com.dw.dw.model.Elev;
import com.dw.dw.model.Nota;
import com.dw.dw.repository.NotaRepository;
import com.dw.dw.repository.ProfesorRepository;
import com.dw.dw.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void deleteById(int id) {
        notaRepository.deleteById(id);
    }

    @Override
    public Nota findNotaById(Integer id) {
        Optional<Nota> elemOptional = notaRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Nota negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public Nota updateNota(Nota nota) {
        return notaRepository.save(nota);
    }

}
