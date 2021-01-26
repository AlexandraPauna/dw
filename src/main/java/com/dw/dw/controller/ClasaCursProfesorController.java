package com.dw.dw.controller;

import com.dw.dw.model.*;
import com.dw.dw.service.*;
import com.dw.dw.utils.SelectListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class ClasaCursProfesorController {
    @Autowired
    InstitutieInvatamantService institutieInvatamantService;

    @Autowired
    ClasaService clasaService;

    @Autowired
    CursService cursService;

    @Autowired
    ProfesorService profesorService;

    @Autowired
    ClasaCursProfesorService clasaCursProfesorService;

    @RequestMapping(value = "/clasa/addCurs", method = RequestMethod.GET)
    public String newClasaCursProfesor(@RequestParam(value = "clasaId", required=false)  Integer clasaId, Model model) {
        List<InstitutieInvatamant> institutii = institutieInvatamantService.getAllInstitutieInvatamant();
        Collections.sort(institutii, new Comparator<InstitutieInvatamant>() {
            @Override
            public int compare(InstitutieInvatamant c1, InstitutieInvatamant c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("institutieList", institutii);

        List<Clasa> clase = clasaService.getAllClasa();
        Collections.sort(clase, new Comparator<Clasa>() {
            @Override
            public int compare(Clasa c1, Clasa c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("clasaList", clase);

        List<Curs> cursuri = cursService.getAllCurs();
        Collections.sort(cursuri, new Comparator<Curs>() {
            @Override
            public int compare(Curs c1, Curs c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("cursList", cursuri);

        List<Profesor> profesorList = profesorService.getAllProfesor();
        Collections.sort(profesorList, new Comparator<Profesor>() {
            @Override
            public int compare(Profesor c1, Profesor c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("profesorList", profesorList);

        ClasaCursProfesor elem = new ClasaCursProfesor();
        if(clasaId !=null) {
            elem.setClasa(clasaService.findClasaById(clasaId));
        }
        model.addAttribute("clasaCursProfesor", elem);

        return "/clasa/addCurs";
    }

    @RequestMapping(value = "/clasa/addCurs", method = RequestMethod.POST)
    public String savedClasaCursProfesor(@Valid ClasaCursProfesor clasaCursProfesor, @RequestParam(value = "clasaId", required=false)  Integer clasaId, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/clasa/addCurs";
        }

        ClasaCursProfesor savedElem = clasaCursProfesorService.saveClasaCursProfesor(clasaCursProfesor);

        if(clasaId != null) {
            return "redirect:/clasa/show/" + clasaId.toString();
        }
        return "redirect:/home/index";
    }

    @RequestMapping(value = "/clasa/addCurs/loadClase/{instId}", method = RequestMethod.GET)
    public @ResponseBody
    List<SelectListItem> getAllSubcategories(@PathVariable("instId") int instId) {
        List<SelectListItem> specializareList = getAllClaseForInstitutie(instId);
        return specializareList;
    }

    public List<SelectListItem> getAllClaseForInstitutie(Integer instId)
    {
        InstitutieInvatamant institutieInvatamant = institutieInvatamantService.findInstitutieInvatamantById(instId);
        List<Clasa> clase = clasaService.getAllClasaForInstitutieInvatamant(institutieInvatamant);
        List<SelectListItem> selectList = new ArrayList<SelectListItem>();

        for (Clasa clasa : clase)
        {
            SelectListItem elem = new SelectListItem();
            elem.setText(clasa.getNume());
            elem.setValue(String.valueOf(clasa.getId()));
            selectList.add(elem);
        }

        return selectList;

    }
}
