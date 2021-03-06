package com.lab.project.controller;

import com.lab.project.model.ChangedUserInfo;
import com.lab.project.model.Trips;
import com.lab.project.model.User;
import com.lab.project.model.UsersReservation;
import com.lab.project.service.TripsService;
import com.lab.project.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserPageController {


    @Autowired
    UserPageService userPageService;
    @Autowired
    TripsService tripsService;


    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/userpage")
    public String getUserPage(Model model){
        UsersReservation[] allTrips = userPageService.getTripsReservedByUser();
        model.addAttribute("Trips", allTrips);
        addUserToModel(model);
        return "userpage";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/userpage/info")
    public String getUserInfo( Model model){
        userPageService.getTripsReservedByUser();
        addUserToModel(model);
        return "fragments::userpage";
    }



    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/userpage/change")
    public String getUserChangeForm( Model model){

        return "fragments::userchangeinfo";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/userpage/addOffer")
    public String getOfferAdditionPage( Model model){

        return "fragments::addOfferPage";
    }



    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PutMapping("/userpage/change")
    public List<FieldError> changeUsersInfo(@Valid @RequestBody ChangedUserInfo changedUserInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println("errory jakieś");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getField() + " - " + error.getRejectedValue());
            }
            return errors;
        }
        else {
            userPageService.changeUsersInfo(changedUserInfo);
        }
        return null;
    }


    @DeleteMapping("/userpage/delete")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<?> deleteCurrentlyLoggedInUser(){
        userPageService.deleteCurrentlyLoggedInUser();
        return new ResponseEntity<>("succes", HttpStatus.OK);
    }


    private void addUserToModel(Model model){

        User user = userPageService.getUserPage();

        String role = user.getRoles().replace('_', ' ');

        model.addAttribute("username", user.getUsername());
        model.addAttribute("firstname", user.getFirstname());
        model.addAttribute("lastname", user.getLastname());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("role", role);
    }

    @ResponseBody
    @PostMapping("/userpage/addOffer")
    public ResponseEntity addNewOffer(@Valid @RequestBody Trips trip, BindingResult bindingResult){




        if (bindingResult.hasErrors()) {
            System.out.println("errory jakieś");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getField() + " - " + error.getRejectedValue());
            }
            return new ResponseEntity(HttpStatus.PARTIAL_CONTENT);
        }
        else {
            tripsService.addNewOffer(trip);
            return new ResponseEntity(HttpStatus.OK);
        }
    }


}
