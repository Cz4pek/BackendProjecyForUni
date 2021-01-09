package com.lab.project.controller;

import com.lab.project.model.ChangedUserInfo;
import com.lab.project.model.Trip;
import com.lab.project.model.User;
import com.lab.project.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/userpage")
    public String getUserPage(Model model){

        addUserToModel(model);
        return "userpage";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/userpage/info")
    public String getUserInfo( Model model){

        addUserToModel(model);
        return "fragments::userpage";
    }



    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/userpage/change")
    public String getUserChangeForm( Model model){

        //addUserToModel(model);

        return "fragments::userchangeinfo";
    }

    @ResponseBody
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


    private void addUserToModel(Model model){

        User user = userPageService.getUserPage();

        String role = user.getRoles().replace('_', ' ');

        model.addAttribute("username", user.getUsername());
        model.addAttribute("firstname", user.getFirstname());
        model.addAttribute("lastname", user.getLastname());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("role", role);
    }


}
