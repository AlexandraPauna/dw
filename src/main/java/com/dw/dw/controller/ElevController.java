package com.dw.dw.controller;

import com.dw.dw.model.*;
import com.dw.dw.service.*;
import com.dw.dw.utils.SelectListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ElevController {

    @Autowired
    ElevService elevService;

    @Autowired
    SpecializareDidacticaService specializareDidacticaService;

    @Autowired
    InstitutieInvatamantService institutieInvatamantService;

    @Autowired
    ClasaService clasaService;

    @RequestMapping(value = "/elev/index", method = RequestMethod.GET)
    public String allElevi(Model model) {

        List<Elev> elevi = elevService.getAllElev();
        Collections.sort(elevi, new Comparator<Elev>() {
            @Override
            public int compare(Elev c1, Elev c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("eleviList", elevi);

        return "/elev/index";
    }

    @RequestMapping(value = "/elev/new", method = RequestMethod.GET)
    public String newElev(@RequestParam(value = "clasaId", required=false)  Integer clasaId, Model model) {
        List<InstitutieInvatamant> institutieList = institutieInvatamantService.getAllInstitutieInvatamant();

        model.addAttribute("institutieList", institutieList);
        model.addAttribute("clase", getAllClase(institutieList.get(0)));

        Elev elev = new Elev();
        if(clasaId !=null) {
            elev.setClasa(clasaService.findClasaById(clasaId));
        }
        else {
            elev.setClasa(clasaService.getAllClasa().get(0));
        }
        model.addAttribute("elev", elev);

        return "/elev/new";
    }

    @RequestMapping(value = "/elev/new", method = RequestMethod.POST)
    public String savedElev(@Valid Elev elev, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            List<InstitutieInvatamant> institutieList = institutieInvatamantService.getAllInstitutieInvatamant();

            model.addAttribute("institutieList", institutieList);
            model.addAttribute("clase", getAllClase(institutieList.get(0)));

            Elev elev1 = new Elev();
            model.addAttribute("elev", elev1);
            return "/elev/new";
        }

        Elev elevSaved = elevService.saveElev(elev);

        return "redirect:/clasa/show/" + elev.getClasa().getId();
    }

    @RequestMapping(value = "/elev/new/loadClase/{profilId}", method = RequestMethod.GET)
    public @ResponseBody  List<SelectListItem> getAllSubcategories(@PathVariable("profilId") int profilId) {
        InstitutieInvatamant institutie = institutieInvatamantService.findInstitutieInvatamantById(profilId);

        return getAllClase(institutie);
    }

    public List<SelectListItem> getAllClase(InstitutieInvatamant institutie)
    {
        Set<Clasa> clase = institutie.getClase();

        List<SelectListItem> selectList = new ArrayList<SelectListItem>();

        for (Clasa cls : clase)
        {
            SelectListItem elem = new SelectListItem();
            elem.setText(cls.getNume());
            elem.setValue(String.valueOf(cls.getId()));
            selectList.add(elem);
        }

        return selectList;
    }

    @GetMapping("/elev/show/{id}")
    public String showInstitutie(@PathVariable String id, Model model){
        model.addAttribute("elev", elevService.findElevById(Integer.valueOf(id)));

        return "elev/show";
    }

    @RequestMapping("elev/{id}/delete")
    public String deleteById(@PathVariable String id){
        elevService.deleteById(Integer.valueOf(id));
        return "redirect:/elev/index";
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
