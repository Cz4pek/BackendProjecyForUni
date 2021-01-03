package com.lab.project.controller;

import com.lab.project.model.Trips;
import com.lab.project.service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripsController {

    @Autowired
    private TripsService service;

    @GetMapping("/world")
    public String getTripsFromWorld( Model model){
        Trips[] allTrips = service.getTripsFromWorld();
        model.addAttribute("Trips", allTrips);
        return "index";
    }

    @GetMapping(path = {"/country", "/"})
    public String getTripsFromCountry( Model model){
        Trips[] allTrips = service.getTripsFromCountry();
        model.addAttribute("Trips", allTrips);
        return "index";
    }

    @GetMapping("/continent")
    public String getTripsFromContinent( Model model){
        Trips[] allTrips = service.getTripsFromContinent();
        model.addAttribute("Trips", allTrips);
        return "index";
    }



}
