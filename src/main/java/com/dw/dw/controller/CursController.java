package com.dw.dw.controller;

import com.dw.dw.model.Curs;
import com.dw.dw.model.Profesor;
import com.dw.dw.model.SpecializareDidactica;
import com.dw.dw.service.CursService;
import com.dw.dw.service.ProfesorService;
import com.dw.dw.service.SpecializareDidacticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.*;

@Controller
public class CursController {
    @Autowired
    CursService cursService;

    @RequestMapping(value = "/curs/index", method = RequestMethod.GET)
    public String allCursuri(Model model) {

        List<Curs> cursuri = cursService.getAllCurs();
        Collections.sort(cursuri, new Comparator<Curs>() {
            @Override
            public int compare(Curs c1, Curs c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("cursuriList", cursuri);

        return "/curs/index";
    }

    @RequestMapping(value = "/curs/new", method = RequestMethod.GET)
    public String newCurs(Model model) {
        Curs curs = new Curs();
        model.addAttribute("curs", curs);

        return "/curs/new";
    }

    @RequestMapping(value = "/curs/new", method = RequestMethod.POST)
    public String savedCurs(@Valid Curs curs, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/curs/new";
        }
        System.out.println(curs.getId());
        System.out.println(curs.getNume());
        Curs savedCurs = cursService.saveCurs(curs);

        return "redirect:/curs/index";
    }
}
