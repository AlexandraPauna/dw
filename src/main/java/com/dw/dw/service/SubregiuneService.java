package com.dw.dw.service;

import com.dw.dw.model.centralizat.Subregiune;

import java.util.List;

public interface SubregiuneService {
    List<Subregiune> getAllSubregiune();
    Subregiune findSubregiuneById(Integer id);
}
