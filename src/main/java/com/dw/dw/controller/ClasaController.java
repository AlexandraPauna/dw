package com.dw.dw.controller;

import com.dw.dw.model.Clasa;
import com.dw.dw.model.InstitutieInvatamant;

import com.dw.dw.model.Profil;
import com.dw.dw.model.Specializare;
import com.dw.dw.service.ClasaService;
import com.dw.dw.service.InstitutieInvatamantService;
import com.dw.dw.service.ProfilService;
import com.dw.dw.service.SpecializareService;
import com.dw.dw.utils.SelectListItem;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Convert;
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

        Clasa savedClasa = clasaService.saveClasa(clasa);

        if(instId != null) {
            return "redirect:/institutie/show/" + instId.toString();
        }
        return "redirect:/institutie/index";
    }

    @RequestMapping(value = "/clasa/new/loadSpecializari/{id}", method = RequestMethod.GET)
    public JSONArray loadSpecializari(@PathVariable Integer id, Model model) {
        List<SelectListItem> specializareList = getAllSpecializari(id);
        System.out.println(specializareList);
        JSONArray jsonArray = new JSONArray(specializareList);
        return jsonArray;
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
}
