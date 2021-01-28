package com.dw.dw.controller;

import com.dw.dw.model.ClasaCursProfesor;
import com.dw.dw.model.Profesor;
import com.dw.dw.model.SpecializareDidactica;
import com.dw.dw.service.ProfesorService;
import com.dw.dw.service.SpecializareDidacticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
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
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @Autowired
    SpecializareDidacticaService specializareDidacticaService;

    private Map<String, SpecializareDidactica> specializareDidacticaCache;

    @RequestMapping(value = "/profesor/index", method = RequestMethod.GET)
    public String allProfesori(Model model) {

        List<Profesor> profesori = profesorService.getAllProfesor();
        Collections.sort(profesori, new Comparator<Profesor>() {
            @Override
            public int compare(Profesor c1, Profesor c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        model.addAttribute("profesoriList", profesori);

        return "/profesor/index";
    }

    @RequestMapping(value = "/profesor/new", method = RequestMethod.GET)
    public String newProfesor(Model model) {
        List<SpecializareDidactica> specializareDidacticaList = specializareDidacticaService.getAllSpecializareDidactica();
        Collections.sort(specializareDidacticaList, new Comparator<SpecializareDidactica>() {
            @Override
            public int compare(SpecializareDidactica c1, SpecializareDidactica c2) {
                return c1.getNume().compareTo(c2.getNume());
            }
        });
        specializareDidacticaCache = new HashMap<String, SpecializareDidactica>();
        for (SpecializareDidactica specializare : specializareDidacticaList) {
            specializareDidacticaCache.put(String.valueOf(specializare.getId()), specializare);
        }

        model.addAttribute("specializareDidacticaList", specializareDidacticaList);

        Profesor profesor = new Profesor();
        model.addAttribute("profesor", profesor);

        return "/profesor/new";
    }

    @RequestMapping(value = "/profesor/new", method = RequestMethod.POST)
    public String savedProfesor(@Valid Profesor profesor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if(profesor.getSpecializari() != null){
                model.addAttribute("specializari", profesor.getSpecializari());
            }
            List<SpecializareDidactica> specializareDidacticaList = specializareDidacticaService.getAllSpecializareDidactica();
            Collections.sort(specializareDidacticaList, new Comparator<SpecializareDidactica>() {
                @Override
                public int compare(SpecializareDidactica c1, SpecializareDidactica c2) {
                    return c1.getNume().compareTo(c2.getNume());
                }
            });
            model.addAttribute("specializareDidacticaList", specializareDidacticaList);
            return "/profesor/new";
        }

        Profesor savedProfesor = profesorService.saveProfesor(profesor);

        return "redirect:/profesor/index";
    }

    @GetMapping("/profesor/show/{id}")
    public String showInstitutie(@PathVariable String id, Model model){
        Profesor prof = profesorService.findProfesorById(Integer.valueOf(id));
        model.addAttribute("profesor", prof);
        Set<SpecializareDidactica> specializari = prof.getSpecializari();
        final String[] specializare = {""};
        specializari.forEach(spec -> specializare[0] = specializare[0] + " " + spec.getNume());
        model.addAttribute("specializari", specializare[0]);

        Set<ClasaCursProfesor> clsCurs= prof.getClasaCursProfesorSet();
        final List<String> cursuri = new ArrayList<String>();
        clsCurs.forEach(item -> {
            cursuri.add(item.getClasa().getNivel() + item.getClasa().getNume() + "-" + item.getClasa().getAn() + "   " + item.getCurs().getNume());

        });
        model.addAttribute("cursuri", cursuri);


        return "profesor/show";
    }

    @RequestMapping("profesor/{id}/delete")
    public String deleteById(@PathVariable String id){
        profesorService.deleteById(Integer.valueOf(id));
        return "redirect:/profesor/index";
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) throws Exception {
//        binder.registerCustomEditor(Set.class, "specializari", new CustomCollectionEditor(Set.class) {
//            protected Object convertElement(Object element) {
//                if (element instanceof SpecializareDidactica) {
//                    System.out.println("Converting from SpecializareDidactica to SpecializareDidactica: " + element);
//                    return element;
//                }
//                if (element instanceof String) {
//                    SpecializareDidactica specializareDidactica = specializareDidacticaService.findSpecializareDidacticaById(specializareDidacticaCache.get(element).getId());
//                    System.out.println("Looking up specializareDidactica for id " + element + ": " + specializareDidactica);
//                    return specializareDidactica;
//                }
//                System.out.println("Don't know what to do with: " + element);
//                return null;
//            }
//        });
//    }

    @InitBinder
    public void initBinder(final WebDataBinder binder){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
