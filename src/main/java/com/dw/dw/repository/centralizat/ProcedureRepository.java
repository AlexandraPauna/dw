package com.dw.dw.repository.centralizat;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.Date;


public interface ProcedureRepository extends JpaRepository<com.dw.dw.model.centralizat.Procedure, Integer> {
    @Procedure("FIND_ELEVI")
     void getAllElevi(Date from, Date to);



}
