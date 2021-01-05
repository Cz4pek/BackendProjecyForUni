package com.lab.project.controller;

import com.lab.project.model.Trip;
import com.lab.project.service.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripsController {

    @Autowired
    private TripsService service;

    @GetMapping("/")
    public String getTripsDefault( Model model){
        Trip[] allTrips = service.getTripsFromCountry();
        model.addAttribute("Trips", allTrips);
        return "index";
    }


    @GetMapping("/world")
    public String getTripsFromWorld( Model model){
        Trip[] allTrips = service.getTripsFromWorld();
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }

    @GetMapping("/country")
    public String getTripsFromCountry( Model model){
        Trip[] allTrips = service.getTripsFromCountry();
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }

    @GetMapping("/continent")
    public String getTripsFromContinent( Model model){
        Trip[] allTrips = service.getTripsFromContinent();
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }



}
