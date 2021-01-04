package com.lab.project.controller;

import com.lab.project.model.ReservationData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController{

    @PostMapping("/form")
    public void insertReservation(@Valid ReservationData reservationData, BindingResult bindingResult){

    }

}
