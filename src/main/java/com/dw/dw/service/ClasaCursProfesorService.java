package com.dw.dw.service;

import com.dw.dw.model.centralizat.ClasaCursProfesor;
import com.dw.dw.model.urban.ClasaCursProfesorUrban;

import java.util.List;

public interface ClasaCursProfesorService {
    List<ClasaCursProfesor> getAllClasaCursProfesor();
    public ClasaCursProfesor findById(int id);
    ClasaCursProfesor saveClasaCursProfesor(ClasaCursProfesor elem);
    void deleteById(int id);
    ClasaCursProfesor findClasaCursProfesorById(Integer id);
    ClasaCursProfesor updateClasaCursProfesor(ClasaCursProfesor elem);

    ClasaCursProfesorUrban saveClasaCursProfesorUrban(ClasaCursProfesorUrban elem);
    ClasaCursProfesorUrban updateClasaCursProfesorUrban(ClasaCursProfesorUrban elem);
    void deleteByIdUrban(int id);
    //public ClasaCursProfesorUrban findByIdUrban(int id);
    ClasaCursProfesorUrban findClasaCursProfesorUrbanById(Integer id);
}
