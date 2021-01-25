package com.dw.dw.service;

import com.dw.dw.model.Regiune;

import java.util.List;

public interface RegiuneService {
    List<Regiune> getAllRegiune();
    Regiune findRegiuneById(Integer id);
}
