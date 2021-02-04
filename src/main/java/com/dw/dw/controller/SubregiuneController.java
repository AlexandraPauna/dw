package com.dw.dw.controller;

import com.dw.dw.model.Subregiune;
import com.dw.dw.service.SubregiuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import java.util.Collections;
import java.util.Comparator;

@Controller
public class SubregiuneController {
    @Autowired
    SubregiuneService subregiuneService;

    @RequestMapping(value = "/subregiune/index", method = RequestMethod.GET)
    public String allSubregiune(Model model) {
        List<Subregiune> subregiuni = subregiuneService.getAllSubregiune();
        Collections.sort(subregiuni, new Comparator<Subregiune>() {
            @Override
            public int compare(Subregiune c1, Subregiune c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("subregiuneList", subregiuni);

        return "/subregiune/index";
    }

    @GetMapping("/subregiune/show/{id}")
    public String showTipZona(@PathVariable String id, Model model){
        model.addAttribute("subregiune", subregiuneService.findSubregiuneById(Integer.valueOf(id)));

        return "/subregiune/show";
    }
}
