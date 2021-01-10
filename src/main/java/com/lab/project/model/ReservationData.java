package com.lab.project.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Calendar;

@Entity
public class ReservationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer res_id;
    @NotBlank
    @Pattern(regexp = "([A-ZĄŚŹŻŁĆÓa-ząśżźłćó]{1,30})(\\s\\d+/*\\d*)+")
    private String adres;
    @NotNull
//    @PositiveOrZero
    private String dzieci;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @PositiveOrZero
    private String iloscPodr;
    @NotBlank
    @Pattern(regexp = "[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19}")
    private String imie;
    @NotBlank
    @Pattern(regexp ="([A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]+\\s?){1,4}")
    private String miasto;
    @NotBlank
    @Pattern(regexp = "([A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})(-?[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})?")
    private String nazwisko;
    private String opcje;
    @NotNull
    @Positive
    private Integer pokoje;
    @Future
    @Temporal(TemporalType.DATE)
    private Calendar powrot;
    @NotBlank
    @Pattern(regexp = "[0-9]{9}")
    private String tel;
    @NotBlank
    private String wycieczka;
    @Future
    @Temporal(TemporalType.DATE)
    private Calendar wyjazd;
    @NotBlank
    @Pattern(regexp ="\\d{2}-\\d{3}")
    private String zip;
    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    @OneToOne
    private Trips trip;

    public Trips getTrip() {
        return trip;
    }

    public void setTrip(Trips trip) {
        this.trip = trip;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user_id) {
        this.user = user_id;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getDzieci() {
        return dzieci;
    }

    public void setDzieci(String dzieci) {
        this.dzieci = dzieci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIloscPodr() {
        return iloscPodr;
    }

    public void setIloscPodr(String iloscPodr) {
        this.iloscPodr = iloscPodr;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getOpcje() {
        return opcje;
    }

    public void setOpcje(String opcje) {
        this.opcje = opcje;
    }

    public Integer getPokoje() {
        return pokoje;
    }

    public void setPokoje(Integer pokoje) {
        this.pokoje = pokoje;
    }

    public Calendar getPowrot() {
        return powrot;
    }

    public void setPowrot(Calendar powrot) {
        this.powrot = powrot;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWycieczka() {
        return wycieczka;
    }

    public void setWycieczka(String wycieczka) {
        this.wycieczka = wycieczka;
    }

    public Calendar getWyjazd() {
        return wyjazd;
    }

    public void setWyjazd(Calendar wyjazd) {
        this.wyjazd = wyjazd;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


    @Override
    public String toString() {
        return "ReservationData{" +
             //   "res_id=" + res_id +
                ", adres='" + adres + '\'' +
                ", dzieci=" + dzieci +
                ", email='" + email + '\'' +
                ", iloscPodr='" + iloscPodr + '\'' +
                ", imie='" + imie + '\'' +
                ", miasto='" + miasto + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", opcje='" + opcje + '\'' +
                ", pokoje=" + pokoje +
                ", powrot=" + powrot.getTime().toInstant() +
                ", tel='" + tel + '\'' +
                ", wycieczka='" + wycieczka + '\'' +
                ", wyjazd=" + wyjazd.getTime().toInstant() +
                ", zip='" + zip + '\'' +
                '}';
    }
}
