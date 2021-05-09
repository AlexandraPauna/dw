package com.dw.dw.controller;

import com.dw.dw.model.centralizat.*;
import com.dw.dw.model.rural.ClasaRural;
import com.dw.dw.model.urban.ClasaCursProfesorUrban;
import com.dw.dw.model.urban.ClasaUrban;
import com.dw.dw.model.urban.InstitutieInvatamantUrban;
import com.dw.dw.service.*;
import com.dw.dw.utils.ObjectConverters;
import com.dw.dw.utils.ObjectConvertersRural;
import com.dw.dw.utils.SelectListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class ClasaController {
    @Autowired
    ClasaService clasaService;

    @Autowired
    ProfilService profilService;

    @Autowired
    SpecializareService specializareService;

    @Autowired
    InstitutieInvatamantService institutieInvatamantService;

    @Autowired
    ElevService elevService;

    @RequestMapping(value = "/clasa/index", method = RequestMethod.GET)
    public String allCursuri(Model model) {

        List<Clasa> clase = clasaService.getAllClasa();
        Collections.sort(clase, new Comparator<Clasa>() {
            @Override
            public int compare(Clasa c1, Clasa c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("claseList", clase);

        return "/clasa/index";
    }

    @RequestMapping(value = "/clasa/new", method = RequestMethod.GET)
    public String newClasa(@RequestParam(value = "inst", required=false)  Integer instId, Model model) {
        List<InstitutieInvatamant> institutii = institutieInvatamantService.getAllInstitutieInvatamant();
        Collections.sort(institutii, new Comparator<InstitutieInvatamant>() {
            @Override
            public int compare(InstitutieInvatamant c1, InstitutieInvatamant c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("institutieList", institutii);

        List<Profil> profilList = profilService.getAllProfil();
        Collections.sort(profilList, new Comparator<Profil>() {
            @Override
            public int compare(Profil c1, Profil c2) {
                return c1.getDenumire().compareTo(c2.getDenumire());
            }
        });
        model.addAttribute("profilList", profilList);

        Clasa clasa = new Clasa();
        if(instId !=null) {
            clasa.setInstitutie(institutieInvatamantService.findInstitutieInvatamantById(instId));
        }
        model.addAttribute("clasa", clasa);

        return "/clasa/new";
    }

    @RequestMapping(value = "/clasa/new", method = RequestMethod.POST)
    public String savedClasa(@Valid Clasa clasa, BindingResult bindingResult, @RequestParam(value = "inst", required=false)  Integer instId, Model model) {
        if (bindingResult.hasErrors()) {
            return "/clasa/new";
        }

        //salvarea pe centralizat
        Clasa savedClasa = clasaService.saveClasa(clasa);

        //salvarea pe fragmentul corespunzator
        if(clasa.getInstitutie().getAdresa().getLocalitate().getTipZona() != null) {
            if(clasa.getInstitutie().getAdresa().getLocalitate().getTipZona().getNume().toUpperCase().equals("URBAN")) {
                //se converteste obiectul
                ClasaUrban clasa_urban = ObjectConverters.clasaCentralizatToUrban.apply(clasa);

                //se adauga in fragmentul urban
                ClasaUrban savedClasa_Urban = clasaService.saveClasaUrban(clasa_urban);
            }
            else if(clasa.getInstitutie().getAdresa().getLocalitate().getTipZona().getNume().toUpperCase().equals("RURAL")){
                //se converteste obiectul
                ClasaRural clasa_rural = ObjectConvertersRural.clasaCentralizatToRural.apply(clasa);

                //se adauga in fragmentul rural
                ClasaRural savedClasa_rural = clasaService.saveClasaRural(clasa_rural);
            }

        }

        if(instId != null) {
            return "redirect:/institutie/show/" + instId.toString();
        }
        return "redirect:/institutie/index";
    }


    @RequestMapping(value = "/clasa/new/loadSpecializari/{profilId}", method = RequestMethod.GET)
    public @ResponseBody  List<SelectListItem> getAllSubcategories(@PathVariable("profilId") int profilId) {
        Profil profil = profilService.findProfilById(profilId);
        System.out.println(profil);
        List<SelectListItem> specializareList = getAllSpecializari(profilId);
        return specializareList;
    }

    public List<SelectListItem> getAllSpecializari(Integer profilId)
    {
        Profil profil = profilService.findProfilById(profilId);
        List<Specializare> specializari = specializareService.getAllSpecializareForProfil(profil);
        List<SelectListItem> selectList = new ArrayList<SelectListItem>();

        for (Specializare spec : specializari)
        {
            SelectListItem elem = new SelectListItem();
            elem.setText(spec.getDenumire());
            elem.setValue(String.valueOf(spec.getId()));
            selectList.add(elem);
        }

        return selectList;
    }

    @GetMapping("/clasa/show/{id}")
    public String showClasa(@PathVariable String id, Model model){
        model.addAttribute("clasa", clasaService.findClasaById(Integer.valueOf(id)));

        List<Elev> elevList = elevService.getAllElev();
        Collections.sort(elevList, new Comparator<Elev>() {
            @Override
            public int compare(Elev c1, Elev c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });

        model.addAttribute("elevList", elevList);

        return "clasa/show";
    }

    @RequestMapping(value = "/clasa/update/{id}", method = RequestMethod.GET)
    public String updateClasa(Model model,@PathVariable int id) {
        List<InstitutieInvatamant> institutii = institutieInvatamantService.getAllInstitutieInvatamant();
        Collections.sort(institutii, new Comparator<InstitutieInvatamant>() {
            @Override
            public int compare(InstitutieInvatamant c1, InstitutieInvatamant c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("institutieList", institutii);

        List<Profil> profilList = profilService.getAllProfil();
        Collections.sort(profilList, new Comparator<Profil>() {
            @Override
            public int compare(Profil c1, Profil c2) {
                return c1.getDenumire().compareTo(c2.getDenumire());
            }
        });
        model.addAttribute("profilList", profilList);

        Clasa clasa = clasaService.findClasaById(id);
        model.addAttribute("clasa", clasa);

        return "/clasa/update";
    }

    @PostMapping(value = "/clasa/update/{id}")
    public String updateClasa(@PathVariable("id") int id,@Valid Clasa clasa,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "/clasa/update";
        }
        Clasa currentElem = clasaService.findClasaById(id);
        currentElem.setNume(clasa.getNume());
        currentElem.setNivel(clasa.getNivel());
        currentElem.setAn(clasa.getAn());
        currentElem.setInstitutie(clasa.getInstitutie());
        currentElem.setSpecializare(clasa.getSpecializare());

        //bd centralizata
        clasaService.updateClasa(currentElem);

        //pe fragmentat
        //se cauta daca e in urban
        if(clasaService.findClasaUrbanById(currentElem.getId()) != null) {
            //se converteste obiectul
            ClasaUrban urban = ObjectConverters.clasaCentralizatToUrban.apply(currentElem);

            //se updateaza in fragmentul urban
            clasaService.updateClasaUrban(urban);
        }
        else if(clasaService.findClasaUrbanById(currentElem.getId()) != null){
            //se converteste obiectul
            ClasaRural clasa_rural = ObjectConvertersRural.clasaCentralizatToRural.apply(currentElem);

            //se adauga in fragmentul rural
            clasaService.updateClasaRural(clasa_rural);
        }

        if (result.hasErrors()){
            return "/clasa/update";
        }

        return "redirect:/clasa/show/" + clasa.getId();

    }

    @RequestMapping("clasa/{id}/delete")
    public String deleteById(@PathVariable String id){
        Clasa currentElem = clasaService.findClasaById(Integer.valueOf(id));
        int idInst = currentElem.getId();

        //bd centralizata
        clasaService.deleteById(Integer.valueOf(id));

        //pe fragmentat
        if(clasaService.findClasaUrbanById(Integer.valueOf(id)) != null) {
            //se sterge din fragmentul urban -> are acelasi id ca si cel din centralizat
            clasaService.deleteByIdUrban(Integer.valueOf(id));

        }

        if(clasaService.findClasaRuralById(Integer.valueOf(id)) != null) {
            //se sterge din fragmentul urban -> are acelasi id ca si cel din centralizat
            clasaService.deleteByIdRural(Integer.valueOf(id));

        }

        return "redirect:/institutie/show/" + idInst;
    }
}
