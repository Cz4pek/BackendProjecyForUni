package com.lab.project.controller;

import com.lab.project.model.Trips;
import com.lab.project.service.TripsService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TripsController {

    @Autowired
    private TripsService tripsService;

    @GetMapping("/")
    public String getTripsDefault( Model model){
        Trips[] allTrips = tripsService.getTripsFrom("kraj");
        model.addAttribute("Trips", allTrips);
//        String encoded=new BCryptPasswordEncoder().encode("pass");
//        System.out.println(encoded);
        return "index";
    }


    @GetMapping("/world")
    public String getTripsFromWorld( Model model){
        Trips[] allTrips = tripsService.getTripsFrom("swiat");
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }

    @GetMapping("/country")
    public String getTripsFromCountry( Model model){

        Trips[] allTrips = tripsService.getTripsFrom("kraj");
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }

    @GetMapping("/continent")
    public String getTripsFrom( Model model){
        Trips[] allTrips = tripsService.getTripsFrom("europa");
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }

//    @DeleteMapping("/trips/delete")

    @RequestMapping(method = RequestMethod.DELETE, path = "/trips/delete")
    public String deleteOffer(@RequestParam int offerId, Model model){
        String category = tripsService.getTripCategoryById(offerId);
        tripsService.deleteOffer(offerId);
        Trips[] allTrips = tripsService.getTripsFrom(category);
        model.addAttribute("Trips", allTrips);
        return "index::offer";
    }
}
