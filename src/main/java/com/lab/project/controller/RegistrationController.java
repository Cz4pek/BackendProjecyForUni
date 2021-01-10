package com.lab.project.controller;

import com.lab.project.model.User;
import com.lab.project.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController{

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String getRegistrationForm(){
        return "register";
    }

    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity registerNewUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println("errory jakieś");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getField() + " - " + error.getRejectedValue());
            }
            return new ResponseEntity(HttpStatus.PARTIAL_CONTENT);
        }
        else {
            if(registrationService.registerNewUser(user)){
                return new ResponseEntity(HttpStatus.OK);
            }
            else {
                System.out.println("Błędna nazwa użytkownika");
                return new ResponseEntity("user or email", HttpStatus.PARTIAL_CONTENT);
            }
        }
    }

}
