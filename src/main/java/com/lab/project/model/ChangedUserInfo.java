package com.lab.project.model;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//@Table(name = "users")
public class ChangedUserInfo {
    @Email
    private  String email;
    @Pattern(regexp = "[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19}")
    private  String firstname;
    @Pattern(regexp = "([A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})(-?[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})?")
    private  String lastname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
