package com.dw.dw.controller;

import com.dw.dw.model.Elev;
import com.dw.dw.model.Regiune;
import com.dw.dw.model.TipZona;
import com.dw.dw.service.TipZonaService;
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
public class TipZonaController {
    @Autowired
    TipZonaService tipZonaService;

    @RequestMapping(value = "/tipzona/index", method = RequestMethod.GET)
    public String allTipZona(Model model) {
        List<TipZona> values = tipZonaService.getAllTipZona();
        Collections.sort(values, new Comparator<TipZona>() {
            @Override
            public int compare(TipZona c1, TipZona c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("tipZonaList", values);

        return "/tipzona/index";
    }

    @GetMapping("/tipzona/show/{id}")
    public String showTipZona(@PathVariable String id, Model model){
        model.addAttribute("tipzona", tipZonaService.findTipZonaById(Integer.valueOf(id)));

        return "/tipzona/show";
    }
}
