package com.dw.dw.service;

import com.dw.dw.model.centralizat.TipZona;

import java.util.List;

public interface TipZonaService {
    List<TipZona> getAllTipZona();
    TipZona findTipZonaById(Integer id);
}
