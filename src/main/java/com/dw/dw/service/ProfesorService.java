package com.dw.dw.service;

import com.dw.dw.model.Profesor;

import java.util.List;

public interface ProfesorService {
    List<Profesor> getAllProfesor();
    public Profesor findById(int id);
    Profesor saveProfesor(Profesor profesor);
    void deleteById(int id);
    Profesor findProfesorById(Integer id);
    Profesor updateProfesor(Profesor profesor);
}
