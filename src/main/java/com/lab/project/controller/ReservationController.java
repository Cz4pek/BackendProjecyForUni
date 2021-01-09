package com.lab.project.controller;

import com.google.common.collect.Lists;
import com.lab.project.model.ReservationData;
import com.lab.project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @RequestMapping(method = RequestMethod.POST, value = "/form")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @ResponseBody
    public ResponseEntity<?> addReservation(@Valid @RequestBody ReservationData reservationData, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println("errory jakieś");
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder res = new StringBuilder("{");
            for (FieldError error : errors ) {
                res.append("\"").append(error.getField()).append("\"").append(": ").append("\"").append(error.getRejectedValue()).append("\", ");
            }
            res.append("}");
            res.delete(res.indexOf("}")-2,res.indexOf("}"));
            System.out.println(res.toString());
            return new ResponseEntity<>(res.toString(), HttpStatus.PARTIAL_CONTENT);
        }
        else {
            System.out.println(reservationData);
            try {
                reservationService.addReservation(reservationData);
            }
            catch (UsernameNotFoundException e){
                return  null;//"User" + e.getMessage() +"}";
            }
            return null;
        }
    }

}
