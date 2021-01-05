package com.lab.project.controller;

import com.lab.project.model.ReservationData;
import com.lab.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FormController{

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/form")
    public List<FieldError> addReservation(@Valid @RequestBody ReservationData reservationData, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println("errory jakieś");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return errors;
        }
        else {
            System.out.println(reservationData);
            reservationService.addReservation(reservationData);
        }
        return null;
    }

}
