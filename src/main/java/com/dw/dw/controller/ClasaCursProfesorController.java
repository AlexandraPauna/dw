package com.dw.dw.controller;

import com.dw.dw.model.centralizat.*;
import com.dw.dw.model.urban.ClasaCursProfesorUrban;
import com.dw.dw.model.urban.NotaUrban;
import com.dw.dw.service.*;
import com.dw.dw.utils.ObjectConverters;
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

    @Autowired
    NotaService notaService;

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
        }else {
            elem.setClasa(clasaService.getAllClasa().get(0));
        }
        model.addAttribute("clasaCursProfesor", elem);

        return "/clasa/addCurs";
    }

    @RequestMapping(value = "/clasa/addCurs", method = RequestMethod.POST)
    public String savedClasaCursProfesor(@Valid ClasaCursProfesor clasaCursProfesor, @RequestParam(value = "clasaId", required=false)  Integer clasaId, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/clasa/addCurs";
        }

        //salvarea pe centralizat
        ClasaCursProfesor savedElem = clasaCursProfesorService.saveClasaCursProfesor(clasaCursProfesor);

        //salvarea pe fragmentul corespunzator
        if(clasaCursProfesor.getClasa().getInstitutie().getAdresa().getLocalitate().getTipZona() != null) {
            if(clasaCursProfesor.getClasa().getInstitutie().getAdresa().getLocalitate().getTipZona().getNume().toUpperCase().equals("URBAN")) {
                //se converteste obiectul
                ClasaCursProfesorUrban urban = ObjectConverters.clasaCursProfesorCentralizatToUrban.apply(clasaCursProfesor);

                //se adauga in fragmentul urban
                ClasaCursProfesorUrban saved_Urban = clasaCursProfesorService.saveClasaCursProfesorUrban(urban);
            }
        //TO DO
        }

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

    @RequestMapping(value = "/clasaCursProfesor/update/{id}", method = RequestMethod.GET)
    public String updateClasaCursProfesor(Model model,@PathVariable int id) {
        List<Profesor> profesorList = profesorService.getAllProfesor();
        Collections.sort(profesorList, new Comparator<Profesor>() {
            @Override
            public int compare(Profesor c1, Profesor c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("profesorList", profesorList);

        ClasaCursProfesor elem = clasaCursProfesorService.findClasaCursProfesorById(id);
        model.addAttribute("clasaCursProfesor", elem);

        return "/clasaCursProfesor/update";
    }

    @PostMapping(value = "/clasaCursProfesor/update/{id}")
    public String updateClasCursProfesora(@PathVariable("id") int id,@Valid ClasaCursProfesor clasaCursProfesor,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "/clasaCursProfesor/update";
        }
        ClasaCursProfesor currentElem = clasaCursProfesorService.findClasaCursProfesorById(id);
//        currentElem.setClasa(clasaCursProfesor.getClasa());
//        currentElem.setCurs(clasaCursProfesor.getCurs());
        currentElem.setProfesor(clasaCursProfesor.getProfesor());

        //bd centralizata
        clasaCursProfesorService.updateClasaCursProfesor(currentElem);

        //pe fragmentat
        //se cauta daca e in urban
        if(clasaCursProfesorService.findClasaCursProfesorUrbanById(currentElem.getId()) != null) {
                    //se converteste obiectul
                    ClasaCursProfesorUrban urban = ObjectConverters.clasaCursProfesorCentralizatToUrban.apply(currentElem);

                    //se updateaza in fragmentul urban
                    clasaCursProfesorService.updateClasaCursProfesorUrban(urban);
        }
        //TO DO else

        if (result.hasErrors()){
            return "/clasaCursProfesor/update";
        }

        return "redirect:/clasaCursProfesor/show/" + clasaCursProfesor.getId();

    }

    @GetMapping("/clasaCursProfesor/show/{id}")
    public String showClasa(@PathVariable String id, Model model){
        model.addAttribute("clasaCursProfesor", clasaCursProfesorService.findClasaCursProfesorById(Integer.valueOf(id)));

        ClasaCursProfesor clasaCursProfesor = clasaCursProfesorService.findClasaCursProfesorById(Integer.valueOf(id));
        List<Elev> eleviList = new ArrayList<>(clasaCursProfesor.getClasa().getElevi());
        Collections.sort(eleviList, new Comparator<Elev>() {
            @Override
            public int compare(Elev c1, Elev c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });

        model.addAttribute("eleviList", eleviList);

        return "clasaCursProfesor/show";
    }

    @RequestMapping("clasaCursProfesor/{id}/delete")
    public String deleteById(@PathVariable String id){
        ClasaCursProfesor currentElem = clasaCursProfesorService.findClasaCursProfesorById(Integer.valueOf(id));
        int idCls = currentElem.getClasa().getId();

        //bd centralizata
        clasaCursProfesorService.deleteById(Integer.valueOf(id));

        //pe fragmentat
        if(clasaCursProfesorService.findClasaCursProfesorUrbanById(Integer.valueOf(id)) != null) {
            //se sterge din fragmentul urban -> are acelasi id ca si cel din centralizat
            clasaCursProfesorService.deleteByIdUrban(Integer.valueOf(id));

            //TO DO
        }

        return "redirect:/clasa/show/" + idCls;
    }
}
