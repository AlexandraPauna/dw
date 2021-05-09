package com.dw.dw.controller;

import com.dw.dw.model.centralizat.Judet;
import com.dw.dw.service.JudetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
