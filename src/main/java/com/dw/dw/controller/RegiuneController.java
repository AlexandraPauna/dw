package com.dw.dw.controller;

import com.dw.dw.model.centralizat.Regiune;
import com.dw.dw.service.RegiuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class RegiuneController {
    @Autowired
    RegiuneService regiuneService;

    @RequestMapping(value = "/regiune/index", method = RequestMethod.GET)
    public String allRegiune(Model model) {
        List<Regiune> regiuni = regiuneService.getAllRegiune();
        Collections.sort(regiuni, new Comparator<Regiune>() {
            @Override
            public int compare(Regiune c1, Regiune c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("regiuneList", regiuni);

        return "/regiune/index";
    }

    @GetMapping("/regiune/show/{id}")
    public String showRegiune(@PathVariable String id, Model model){
        model.addAttribute("regiune", regiuneService.findRegiuneById(Integer.valueOf(id)));

        return "/regiune/show";
    }
}
