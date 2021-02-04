package com.dw.dw.controller;

import com.dw.dw.model.Adresa;
import com.dw.dw.model.InstitutieInvatamant;
import com.dw.dw.model.Judet;
import com.dw.dw.model.Localitate;
import com.dw.dw.service.JudetService;
import com.dw.dw.service.LocalitateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class JudetController {
    @Autowired
    JudetService judetService;

    @GetMapping("/judet/show/{id}")
    public String showJudet(@PathVariable String id, Model model){
        Judet judet = judetService.findJudetById(Integer.valueOf(id));
        model.addAttribute("judet", judet);

        return "/judet/show";
    }
}
