package com.lab.project.controller;


import com.lab.project.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {


    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){ // specifying model as on object on Registration class and naming it registration

        return "WEB-INF/jsp/greeting.jsp";
    }
    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute("registration")Registration registration, BindingResult result){

        if(result.hasErrors()) {
            System.out.println("Jakieś błędy się pojawiły");
            return "registration";
        }
        System.out.println("Registration: " + registration.getName());
        return "redirect:registration";
    }
}
