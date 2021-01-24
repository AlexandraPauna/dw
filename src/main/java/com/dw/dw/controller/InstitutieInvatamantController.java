package com.dw.dw.controller;

import com.dw.dw.model.InstitutieInvatamant;
import com.dw.dw.model.TipInstitutie;
import com.dw.dw.service.InstitutieInvatamantService;
import com.dw.dw.service.TipInstitutieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class InstitutieInvatamantController {
    @Autowired
    InstitutieInvatamantService institutieInvatamantService;

    @Autowired
    TipInstitutieService tipInstitutieService;

    @RequestMapping(value = "/institutie/index", method = RequestMethod.GET)
    public String allInstitutii(Model model) {

        List<InstitutieInvatamant> institutii = institutieInvatamantService.getAllInstitutieInvatamant();
        Collections.sort(institutii, new Comparator<InstitutieInvatamant>() {
            @Override
            public int compare(InstitutieInvatamant c1, InstitutieInvatamant c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });

        model.addAttribute("institutiiList", institutii);

        return "/institutie/index";
    }

    @RequestMapping(value = "/institutie/new", method = RequestMethod.GET)
    public String newInstitutie(Model model) {
        model.addAttribute("tipInstitutieList", tipInstitutieService.getAllTipInstitutie());

        InstitutieInvatamant institutie = new InstitutieInvatamant();
        model.addAttribute("institutie", institutie);

        return "/institutie/new";
    }
}
