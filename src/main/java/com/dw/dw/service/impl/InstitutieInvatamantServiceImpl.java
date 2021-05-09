package com.dw.dw.service.impl;

import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.rural.InstitutieInvatamantRural;
import com.dw.dw.model.urban.InstitutieInvatamantUrban;
import com.dw.dw.repository.centralizat.InstitutieInvatamantRepository;
import com.dw.dw.repository.rural.InstitutieInvatamantRuralRepository;
import com.dw.dw.repository.urban.InstitutieInvatamantUrbanRepository;
import com.dw.dw.service.InstitutieInvatamantService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutieInvatamantServiceImpl implements InstitutieInvatamantService {

    private final InstitutieInvatamantRepository institutieInvatamantRepository;

    private final InstitutieInvatamantUrbanRepository institutieInvatamantRepository_Urban;
    private final InstitutieInvatamantRuralRepository institutieInvatamantRepository_Rural;

    @Autowired
    public InstitutieInvatamantServiceImpl(InstitutieInvatamantRepository institutieInvatamantRepository, InstitutieInvatamantUrbanRepository institutieInvatamantRepository_urban, InstitutieInvatamantRuralRepository institutieInvatamantRepository_rural) {
        this.institutieInvatamantRepository = institutieInvatamantRepository;
        this.institutieInvatamantRepository_Urban = institutieInvatamantRepository_urban;
        this.institutieInvatamantRepository_Rural = institutieInvatamantRepository_rural;
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

    //URBAN
    @Override
    public InstitutieInvatamantUrban saveInstitutieInvatamant_Urban(InstitutieInvatamantUrban institutieInvatamant) {
        return institutieInvatamantRepository_Urban.saveAndFlush(institutieInvatamant);
    }

    @Override
    public void deleteByIdUrban(int id) {
        institutieInvatamantRepository_Urban.deleteById(id);
    }

    @Override
    public InstitutieInvatamantUrban findInstitutieInvatamantByIdUrban(Integer id) {
        Optional<InstitutieInvatamantUrban> institutieInvatamantOptional = institutieInvatamantRepository_Urban.findById(id);

        if (!institutieInvatamantOptional.isPresent()) {
            throw new RuntimeException("Institutie Invatamant Urban negasita!");
        }

        return institutieInvatamantOptional.get();
    }

    @Override
    public InstitutieInvatamantUrban updateInstitutieInvatamantUrban(InstitutieInvatamantUrban institutieInvatamant) {
        return institutieInvatamantRepository_Urban.save(institutieInvatamant);
    }

    //RURAL
    @Override
    public InstitutieInvatamantRural saveInstitutieInvatamant_Rural(InstitutieInvatamantRural institutieInvatamant) {
        return institutieInvatamantRepository_Rural.saveAndFlush(institutieInvatamant);
    }

    @Override
    public void deleteByIdRural(int id) {
        institutieInvatamantRepository_Rural.deleteById(id);
    }

    @Override
    public InstitutieInvatamantRural findInstitutieInvatamantByIdRural(Integer id) {
        Optional<InstitutieInvatamantRural> institutieInvatamantOptional = institutieInvatamantRepository_Rural.findById(id);

        if (!institutieInvatamantOptional.isPresent()) {
            throw new RuntimeException("Institutie Invatamant Rural negasita!");
        }

        return institutieInvatamantOptional.get();
    }

    @Override
    public InstitutieInvatamantRural updateInstitutieInvatamantRural(InstitutieInvatamantRural institutieInvatamant) {
        return institutieInvatamantRepository_Rural.save(institutieInvatamant);
    }
}
