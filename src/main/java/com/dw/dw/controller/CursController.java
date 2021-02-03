package com.dw.dw.controller;

import com.dw.dw.model.*;
import com.dw.dw.service.CursService;
import com.dw.dw.service.ProfesorService;
import com.dw.dw.service.SpecializareDidacticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/curs/update/{id}", method = RequestMethod.GET)
    public String updateCurs(Model model,@PathVariable int id) {

        Curs curs = cursService.findCursById(id);
        model.addAttribute("curs", curs);

        return "/curs/update";
    }

    @PostMapping(value = "/curs/update/{id}")
    public String updateCurs(@PathVariable("id") int id,@Valid Curs curs,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "/curs/update";
        }
        Curs currentElem = cursService.findCursById(id);
        currentElem.setNume(curs.getNume());

        cursService.updateCurs(currentElem);
        if (result.hasErrors()){
            return "/curs/update";
        }

        allCursuri(model);
        return "redirect:/curs/index";
    }

    @GetMapping("/curs/show/{id}")
    public String showCurs(@PathVariable String id, Model model){
        Curs curs = cursService.findCursById(Integer.valueOf(id));
        if (curs.getClasaCursProfesorSet() != null) {
            List<ClasaCursProfesor> clasaCursProfesorList = new ArrayList<> (curs.getClasaCursProfesorSet());
            Collections.sort(clasaCursProfesorList, new Comparator<ClasaCursProfesor>() {
                @Override
                public int compare(ClasaCursProfesor c1, ClasaCursProfesor c2) {
                    return c1.getClasa().getInstitutie().getNume().compareTo(c2.getClasa().getInstitutie().getNume());
                }
            });
            model.addAttribute("clasaCursProfesorList", clasaCursProfesorList);
        }
        model.addAttribute("curs", curs);

        return "curs/show";
    }

    @RequestMapping("curs/{id}/delete")
    public String deleteById(@PathVariable String id){
        //Curs curs
        cursService.deleteById(Integer.valueOf(id));
        return "redirect:/curs/index";
    }
}
