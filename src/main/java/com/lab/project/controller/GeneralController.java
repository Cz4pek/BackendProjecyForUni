package com.lab.project.controller;

import com.lab.project.auth.AppUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/form")
    public String getForm(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(String.format("Username %s Password %s Roles %s Details %s", ((AppUser)auth.getPrincipal()).getUsername(), auth.getCredentials(), auth.getAuthorities(), auth.getDetails()));

        return "form";
    }

}
