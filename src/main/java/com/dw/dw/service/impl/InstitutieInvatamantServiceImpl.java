package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.repository.centralizat.InstitutieInvatamantRepository;
import com.dw.dw.service.InstitutieInvatamantService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutieInvatamantServiceImpl implements InstitutieInvatamantService {

    private final InstitutieInvatamantRepository institutieInvatamantRepository;

    @Autowired
    public InstitutieInvatamantServiceImpl(InstitutieInvatamantRepository institutieInvatamantRepository) {
        this.institutieInvatamantRepository = institutieInvatamantRepository;
    }

    @Override
    public List<InstitutieInvatamant> getAllInstitutieInvatamant() {

        return institutieInvatamantRepository.findAll();
    }

    @Override
    public InstitutieInvatamant findById(int id) {
        Optional<InstitutieInvatamant> institutieInvatamantOptional = institutieInvatamantRepository.findById(id);

        if (institutieInvatamantOptional.isPresent())
            return institutieInvatamantOptional.get();
        else
            throw new ResourceNotFoundException("institutie invatamant " + id + " not found");
    }

    @Override
    public InstitutieInvatamant saveInstitutieInvatamant(InstitutieInvatamant institutieInvatamant) {
        return institutieInvatamantRepository.saveAndFlush(institutieInvatamant);
    }

    @Override
    public void deleteById(int id) {
        institutieInvatamantRepository.deleteById(id);
    }

    @Override
    public InstitutieInvatamant findInstitutieInvatamantById(Integer id) {
        Optional<InstitutieInvatamant> institutieInvatamantOptional = institutieInvatamantRepository.findById(id);

        if (!institutieInvatamantOptional.isPresent()) {
            throw new RuntimeException("Institutie Invatamant negasita!");
        }

        return institutieInvatamantOptional.get();
    }

    @Override
    public InstitutieInvatamant updateInstitutieInvatamant(InstitutieInvatamant institutieInvatamant) {
        return institutieInvatamantRepository.save(institutieInvatamant);
    }

}
