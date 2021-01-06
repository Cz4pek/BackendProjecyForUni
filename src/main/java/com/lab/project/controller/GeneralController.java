package com.lab.project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/form")
    public String getForm(){
        return "form";
    }

}
