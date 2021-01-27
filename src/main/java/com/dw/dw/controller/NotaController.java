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
public class NotaController {

    @Autowired
    ElevService elevService;

    @Autowired
    NotaService notaService;

    @Autowired
    InstitutieInvatamantService institutieInvatamantService;

    @Autowired
    ClasaService clasaService;

    @Autowired
    CursService cursService;

    @RequestMapping(value = "/nota/index", method = RequestMethod.GET)
    public String allNote(Model model) {

        List<Nota> note = notaService.getAllNote();
        Collections.sort(note, new Comparator<Nota>() {
            @Override
            public int compare(Nota c1, Nota c2) {
                return c1.getElev().getNume().compareTo(c2.getElev().getNume());
            }
        });
        model.addAttribute("noteList", note);

        return "/nota/index";
    }

    @RequestMapping(value = "/nota/new", method = RequestMethod.GET)
    public String newElev(Model model, @RequestParam("elevId") int elevId) {
        Elev elev = elevService.findElevById(elevId);
        model.addAttribute("elev", elev);

        List<Curs> cursList = new ArrayList<Curs>();
        elev.getClasa().getClasaCursProfesorSet().forEach(item -> {
            cursList.add(item.getCurs());
        });

        model.addAttribute("cursList", cursList);

        Nota nota = new Nota();
        nota.setElev(elev);
        model.addAttribute("nota", nota);

        return "/nota/new";
    }

    @RequestMapping(value = "/nota/new", method = RequestMethod.POST)
    public String savedElev(@Valid Nota nota, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {

            Elev elev1 = new Elev();
            model.addAttribute("elev", elev1);
            return "/nota/new";
        }

        Nota notaSaved = notaService.saveNota(nota);

        return "redirect:/nota/index";
    }

    @RequestMapping(value = "/nota/new/loadClasa/{profilId}", method = RequestMethod.GET)
    public @ResponseBody
    List<SelectListItem> getAllClasa(@PathVariable("profilId") int findById) {
        InstitutieInvatamant instit = institutieInvatamantService.findById(findById);

        return getAllClase(instit);
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

    @InitBinder
    public void initBinder(final WebDataBinder binder){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
