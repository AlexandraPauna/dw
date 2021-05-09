package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.Nota;
import com.dw.dw.model.rural.NotaRural;
import com.dw.dw.model.urban.NotaUrban;
import com.dw.dw.repository.centralizat.NotaRepository;
import com.dw.dw.repository.rural.NotaRuralRepository;
import com.dw.dw.repository.urban.NotaUrbanRepository;
import com.dw.dw.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaServiceImpl implements NotaService {

    public final NotaRepository notaRepository;
    public final NotaUrbanRepository notaUrbanRepository;
    public final NotaRuralRepository notaRuralRepository;

    @Autowired
    public NotaServiceImpl(NotaRepository notaRepository, NotaUrbanRepository notaUrbanRepository, NotaRuralRepository notaRuralRepository) {
        this.notaRepository = notaRepository;
        this.notaUrbanRepository = notaUrbanRepository;
        this.notaRuralRepository = notaRuralRepository;
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

    @Override
    public NotaUrban saveNotaUrban(NotaUrban nota) {
        return notaUrbanRepository.save(nota);
    }

    @Override
    public void deleteByIdUrban(int id) {
        notaUrbanRepository.deleteById(id);
    }

    @Override
    public NotaUrban findNotaByIdUrban(Integer id) {
        Optional<NotaUrban> elemOptional = notaUrbanRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Nota negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public NotaUrban updateNotaUrban(NotaUrban nota) {
        return notaUrbanRepository.save(nota);
    }

    //RURAL
    @Override
    public NotaRural saveNotaRural(NotaRural nota) {
        return notaRuralRepository.save(nota);
    }

    @Override
    public void deleteByIdRural(int id) {
        notaRuralRepository.deleteById(id);
    }

    @Override
    public NotaRural findNotaByIdRural(Integer id) {
        Optional<NotaRural> elemOptional = notaRuralRepository.findById(id);

        if (!elemOptional.isPresent()) {
            throw new RuntimeException("Nota Rural negasita!");
        }

        return elemOptional.get();
    }

    @Override
    public NotaRural updateNotaRural(NotaRural nota) {
        return notaRuralRepository.save(nota);
    }

}
