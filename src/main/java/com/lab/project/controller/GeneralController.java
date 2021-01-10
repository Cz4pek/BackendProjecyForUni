package com.lab.project.controller;

import com.lab.project.auth.AppUser;
import com.lab.project.model.Trips;
import com.lab.project.service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @Autowired
    private TripsService tripsService;

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
    public String getForm(Model model){
        Trips[] trips = tripsService.getAllAvailableOffers();
        model.addAttribute("Trips", trips);
        return "form";
    }



}
