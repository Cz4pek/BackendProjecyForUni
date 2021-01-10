package com.lab.project.model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class UsersReservation {
    public UsersReservation(Trips trip, ReservationData reservationData) {
        SimpleDateFormat dateFormatter =  new SimpleDateFormat("yyyy-MM-dd");

        img_url = trip.getImg_url();
        title = trip.getTitle();
        summary = trip.getTitle();
        bodytitle = trip.getBodytitle();
        info = trip.getInfo();
        price = trip.getPrice();
        adres = reservationData.getAdres();
        dzieci = reservationData.getDzieci();
        email = reservationData.getEmail();
        iloscPodr = reservationData.getIloscPodr();
        imie = reservationData.getImie();
        miasto = reservationData.getMiasto();
        nazwisko = reservationData.getNazwisko();
        opcje = reservationData.getOpcje();
        pokoje = reservationData.getPokoje();
        powrot = dateFormatter.format(reservationData.getPowrot().getTime());
        tel = reservationData.getTel();
        wyjazd = dateFormatter.format(reservationData.getWyjazd().getTime());
        zip = reservationData.getZip();
        id = reservationData.getRes_id();
    }
    //@NotBlank
    //@Pattern(regexp = "([A-ZĄŚŹŻŁĆÓa-ząśżźłćó]{1,30})(\\s\\d+/*\\d*)+")

    private final int id;
    private final String adres;
    //@NotNull
//    @PositiveOrZero
    private final String dzieci;
    //@NotBlank
    //@Email
    private final String email;
    //@NotBlank
    //@PositiveOrZero
    private final String iloscPodr;
    //@NotBlank
    //@Pattern(regexp = "[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19}")
    private final String imie;
    //@NotBlank
    //@Pattern(regexp ="([A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]+\\s?){1,4}")
    private final String miasto;
    //@NotBlank
    //@Pattern(regexp = "([A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})(-?[A-ZĄŚŹŻŁĆÓ]{1}[a-ząśżźłćó]{1,19})?")
    private final String nazwisko;
    private final String opcje;
    //@NotNull
    //@Positive
    private final Integer pokoje;
    //@Future
    //@Temporal(TemporalType.DATE)
    private final String powrot;
    //@NotBlank
    //@Pattern(regexp = "[0-9]{9}")
    private final String tel;
    //@Future
    //@Temporal(TemporalType.DATE)
    private final String wyjazd;
    //@NotBlank
    //@Pattern(regexp ="\\d{2}-\\d{3}")
    private final String zip;
    //@NotNull
    private final String img_url;
    //@NotNull
    private final String title;
    //@NotNull
    private final String summary;
    //@NotNull
    private final String bodytitle;
    //@NotNull
    private final String info;
    //@NotNull
    private final String price;


    public String getAdres() {
        return adres;
    }

    public String getDzieci() {
        return dzieci;
    }

    public String getEmail() {
        return email;
    }

    public String getIloscPodr() {
        return iloscPodr;
    }

    public String getImie() {
        return imie;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getOpcje() {
        return opcje;
    }

    public Integer getPokoje() {
        return pokoje;
    }

    public String getPowrot() {
        return powrot;
    }

    public String getTel() {
        return tel;
    }

    public String getWyjazd() {
        return wyjazd;
    }

    public String getZip() {
        return zip;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getBodytitle() {
        return bodytitle;
    }

    public String getInfo() {
        return info;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
