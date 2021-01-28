package com.dw.dw.controller;

import com.dw.dw.model.Curs;
import com.dw.dw.model.Elev;
import com.dw.dw.model.Nota;
import com.dw.dw.model.Procedure;
import com.dw.dw.service.ElevService;
import com.dw.dw.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProcedureController {

    @Autowired
    ProcedureService procedureService;

    @RequestMapping(value = "/procedure/new", method = RequestMethod.GET)
    public String newProc(Model model) {

        Date dataStart = new Date();
        Date dataStop = new Date();
        model.addAttribute("dataStart", dataStart);
        model.addAttribute("dataStop", dataStop);
        model.addAttribute("procedure", new Procedure());

        return "/procedure/new";
    }

    @RequestMapping(value = "/procedure/new", method = RequestMethod.POST)
    public String doProc(@Valid Procedure proc, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "/procedure/new";
        }
        procedureService.doProcedure(proc.getDataStart(), proc.getDataStop());


        return "procedure/show";
    }

    @RequestMapping(value = "/procedure/show", method = RequestMethod.GET)
    public String showProc(Model model) {

        return "/procedure/show";
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
