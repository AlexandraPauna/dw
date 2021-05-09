package com.dw.dw.service;

import com.dw.dw.model.centralizat.Profesor;
import com.dw.dw.model.urban.ProfesorUrban;

import java.util.List;

public interface ProfesorService {
    List<Profesor> getAllProfesor();
    public Profesor findById(int id);
    Profesor saveProfesor(Profesor profesor);
    void deleteById(int id);
    Profesor findProfesorById(Integer id);
    Profesor updateProfesor(Profesor profesor);

    ProfesorUrban saveProfesorUrban(ProfesorUrban profesor);
    void deleteByIdUrban(int id);
    ProfesorUrban findProfesorByIdUrban(Integer id);
    ProfesorUrban updateProfesorUrban(ProfesorUrban profesor);
}
