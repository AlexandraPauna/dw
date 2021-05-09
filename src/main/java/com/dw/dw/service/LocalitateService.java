package com.dw.dw.service;

import com.dw.dw.model.centralizat.Localitate;

import java.util.List;

public interface LocalitateService {
    List<Localitate> getAllLocalitate();
    Localitate saveLocalitate(Localitate localitate);
    void deleteById(int id);
    Localitate findLocalitateById(Integer id);
    Localitate updateLocalitate(Localitate localitate);
}
