package com.dw.dw.controller;

import com.dw.dw.model.*;
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
public class LocalitateController {
    @Autowired
    LocalitateService localitateService;

    @GetMapping("/localitate/show/{id}")
    public String showTipZona(@PathVariable String id, Model model){
        Localitate localitate = localitateService.findLocalitateById(Integer.valueOf(id));
        model.addAttribute("localitate", localitate);

        List<Adresa> adr = new ArrayList<>(localitate.getAdrese());
        List<InstitutieInvatamant> instList = new ArrayList<InstitutieInvatamant>();
        adr.forEach(item -> {
            instList.add(item.getInstitutieInvatamant());
        });
        Collections.sort(instList, new Comparator<InstitutieInvatamant>() {
            @Override
            public int compare(InstitutieInvatamant c1, InstitutieInvatamant c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("instList", instList);

        return "/localitate/show";
    }
}
