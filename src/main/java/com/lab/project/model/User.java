package com.lab.project.model;


import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^(?=.{4,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$")
    private  String username;
    @NotBlank
    @Length(min = 6)
    private  String password;
    @Email
    @NotBlank
    private  String email;
    @NotBlank
    @Pattern(regexp = "[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19}")
    private  String firstname;
    @NotBlank
    @Pattern(regexp = "([A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})(-?[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})?")
    private  String lastname;
    @NotBlank
    @Pattern(regexp = "^ROLE_USER$|^ROLE_ADMIN$")
    private String roles;
//
//    @NotBlank
//    @Pattern(regexp = "[0-9]{9}")
//    private String tel;

    private  boolean isAccountNonExpired;
    private  boolean isAccountNonLocked;
    private  boolean isCredentialsNonExpired;
    private  boolean isEnabled;
    public User() {
        roles = "ROLE_USER";
        isAccountNonExpired = true;
        isAccountNonLocked = true;
        isCredentialsNonExpired = true;
        isEnabled = true;
    }

//    public String getTel() {
//        return tel;
//    }
//
//    public void setTel(String tel) {
//        this.tel = tel;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
