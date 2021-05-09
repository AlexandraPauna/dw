package com.dw.dw.service.impl;

import com.dw.dw.repository.centralizat.ProcedureRepository;
import com.dw.dw.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Date;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    @Autowired
    public ProcedureServiceImpl(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }


    public void doProcedure(Date from, Date to) {
//        procedureRepository.getAllElevi(from, to);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/orclpdb", "olap_admin", "parola");

            java.sql.Date f = convertUtilToSql(from);
            java.sql.Date t = convertUtilToSql(to);
            CallableStatement proc = con.prepareCall(
                    "call POPULARE_WAREHOUSE_SEMESTRU(?,?)");
            proc.setDate(1, f);
            proc.setDate(2, t);
            proc.execute();

//            System.out.println(rs);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
