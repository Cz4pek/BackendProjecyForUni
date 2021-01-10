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
    private TripsService tripsService;

    @GetMapping("/")
    public String getTripsDefault( Model model){
        Trips[] allTrips = tripsService.getTripsFromCountry();
        model.addAttribute("Trips", allTrips);
//        String encoded=new BCryptPasswordEncoder().encode("pass");
//        System.out.println(encoded);
        return "index";
    }


    @GetMapping("/world")
    public String getTripsFromWorld( Model model){
        Trips[] allTrips = tripsService.getTripsFromWorld();
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }

    @GetMapping("/country")
    public String getTripsFromCountry( Model model){

        Trips[] allTrips = tripsService.getTripsFromCountry();
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }

    @GetMapping("/continent")
    public String getTripsFromContinent( Model model){
        Trips[] allTrips = tripsService.getTripsFromContinent();

        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }



}
