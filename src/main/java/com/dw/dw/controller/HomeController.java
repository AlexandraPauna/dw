package com.dw.dw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String homeIndex() {
        return "home/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home/index";
    }
}
