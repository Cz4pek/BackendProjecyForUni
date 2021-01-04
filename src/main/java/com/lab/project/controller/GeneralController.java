package com.lab.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/gallery")
    public String getGallery(){
        return "galeria";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "kontakt";
    }

    @GetMapping("/form")
    public String getForm(){
        return "form";
    }

}
