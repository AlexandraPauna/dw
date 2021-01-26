package com.dw.dw.service;

import com.dw.dw.model.ClasaCursProfesor;

import java.util.List;

public interface ClasaCursProfesorService {
    List<ClasaCursProfesor> getAllClasaCursProfesor();
    public ClasaCursProfesor findById(int id);
    ClasaCursProfesor saveClasaCursProfesor(ClasaCursProfesor elem);
    void deleteById(int id);
    ClasaCursProfesor findClasaCursProfesorById(Integer id);
    ClasaCursProfesor updateClasaCursProfesor(ClasaCursProfesor elem);
}
