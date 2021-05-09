package com.dw.dw.controller;

import com.dw.dw.model.centralizat.Clasa;
import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.centralizat.Localitate;
import com.dw.dw.model.centralizat.TipInstitutie;
import com.dw.dw.model.urban.AdresaUrban;
import com.dw.dw.model.urban.InstitutieInvatamantUrban;
import com.dw.dw.service.InstitutieInvatamantService;
import com.dw.dw.service.LocalitateService;
import com.dw.dw.service.TipInstitutieService;
import com.dw.dw.utils.ObjectConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.function.Function;

import static org.springframework.beans.BeanUtils.copyProperties;

@Controller
public class InstitutieInvatamantController {
    @Autowired
    InstitutieInvatamantService institutieInvatamantService;

    @Autowired
    TipInstitutieService tipInstitutieService;

    @Autowired
    LocalitateService localitateService;

    @RequestMapping(value = "/institutie/index", method = RequestMethod.GET)
    public String allInstitutii(Model model) {

        List<InstitutieInvatamant> institutii = institutieInvatamantService.getAllInstitutieInvatamant();
        Collections.sort(institutii, new Comparator<InstitutieInvatamant>() {
            @Override
            public int compare(InstitutieInvatamant c1, InstitutieInvatamant c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });

        model.addAttribute("institutiiList", institutii);

        return "/institutie/index";
    }

    @RequestMapping(value = "/institutie/new", method = RequestMethod.GET)
    public String newInstitutie(Model model) {
        model.addAttribute("tipInstitutieList", tipInstitutieService.getAllTipInstitutie());
        model.addAttribute("localitateList", localitateService.getAllLocalitate());

        InstitutieInvatamant institutie = new InstitutieInvatamant();
        model.addAttribute("institutie", institutie);

        return "/institutie/new";
    }

    @RequestMapping(value = "/institutie/new", method = RequestMethod.POST)
    public String savedInstitutie(@Valid InstitutieInvatamant institutie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/institutie/new";
        }

        //salvarea pe centralizat
        InstitutieInvatamant savedRecipe = institutieInvatamantService.saveInstitutieInvatamant(institutie);

        //salvarea pe fragmentul corespunzator
        if(institutie.getAdresa().getLocalitate().getTipZona() != null) {
            if(institutie.getAdresa().getLocalitate().getTipZona().getNume().toUpperCase().equals("URBAN")) {
                //se converteste obiectul
                InstitutieInvatamantUrban institutie_urban = ObjectConverters.centralizatToUrban.apply(institutie);

                //se adauga in fragmentul urban
                InstitutieInvatamantUrban savedInstitutie_Urban = institutieInvatamantService.saveInstitutieInvatamant_Urban(institutie_urban);
            }

        }

        return "redirect:/institutie/index";
    }

    @GetMapping("/institutie/show/{id}")
    public String showInstitutie(@PathVariable String id, Model model){
        InstitutieInvatamant institutieInvatamant = institutieInvatamantService.findInstitutieInvatamantById(Integer.valueOf(id));
        if (institutieInvatamant.getClase() != null) {
            List<Clasa> clasaList = new ArrayList<> (institutieInvatamant.getClase());
            Collections.sort(clasaList, new Comparator<Clasa>() {
                @Override
                public int compare(Clasa c1, Clasa c2) {
                    return c1.getNume().compareTo(c2.getNume());
                }
            });
            model.addAttribute("clasaList", clasaList);
        }
        model.addAttribute("institutie", institutieInvatamant);

        return "institutie/show";
    }

    @RequestMapping(value = "/institutie/update/{id}", method = RequestMethod.GET)
    public String updateInstitutie(Model model,@PathVariable int id) {
        List<TipInstitutie> tipInstitutieList = tipInstitutieService.getAllTipInstitutie();
        Collections.sort(tipInstitutieList, new Comparator<TipInstitutie>() {
            @Override
            public int compare(TipInstitutie c1, TipInstitutie c2) {
                return c1.getDenumire().compareTo(c2.getDenumire());
            }
        });

        List<Localitate> localitateList = localitateService.getAllLocalitate();
        Collections.sort(localitateList, new Comparator<Localitate>() {
            @Override
            public int compare(Localitate c1, Localitate c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });

        model.addAttribute("tipInstitutieList", tipInstitutieList);
        model.addAttribute("localitateList", localitateList);

        InstitutieInvatamant institutie = institutieInvatamantService.findInstitutieInvatamantById(id);
        model.addAttribute("institutie", institutie);

        return "/institutie/update";
    }

    @PostMapping(value = "/institutie/update/{id}")
    public String updateInstitutie(@PathVariable("id") int id,@Valid InstitutieInvatamant institutie,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "/institutie/update";
        }
        InstitutieInvatamant currentElem = institutieInvatamantService.findInstitutieInvatamantById(id);
        currentElem.setNume(institutie.getNume());
        currentElem.setTipInstitutie(institutie.getTipInstitutie());
        currentElem.setAdresa(institutie.getAdresa());
        currentElem.setClase(institutie.getClase());

        institutieInvatamantService.updateInstitutieInvatamant(currentElem);
        if (result.hasErrors()){
            return "/institutie/update";
        }

        allInstitutii(model);
        return "redirect:/institutie/index";

    }

    @RequestMapping("institutie/{id}/delete")
    public String deleteById(@PathVariable String id){
        institutieInvatamantService.deleteById(Integer.valueOf(id));
        return "redirect:/institutie/index";
    }
}
