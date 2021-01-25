package com.dw.dw.service;

import com.dw.dw.model.TipZona;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TipZonaService {
    List<TipZona> getAllTipZona();
    TipZona findTipZonaById(Integer id);
}
