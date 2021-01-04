package com.lab.project.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Calendar;

@Entity
public class ReservationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer res_id;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")
    private String adres;
    @NotNull
    private Integer dzieci;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String iloscPodr;
    @NotNull
    private String imie;
    @NotNull
    private String miasto;
    @NotNull
    private String nazwisko;
    private String opcje;
    @NotNull
    private Integer pokoje;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Calendar powrot;
    @NotNull
    private String tel;
    @NotNull
    private String wycieczka;
    @Temporal(TemporalType.DATE)
    private Calendar wyjazd;
    @NotNull
    private String zip;

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

    public Integer getDzieci() {
        return dzieci;
    }

    public void setDzieci(Integer dzieci) {
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
}
