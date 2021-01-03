package com.lab.project.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class Trips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trip_id;
    @NotNull
    private String img_url;
    @NotNull
    private String title;
    @NotNull
    private String summary;
    @NotNull
    private String bodyTitle;
    @NotNull
    private String info;
    @NotNull
    private String price;
    @NotNull
    private String category;

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBodyTitle() {
        return bodyTitle;
    }

    public void setBodyTitle(String bodyTitle) {
        this.bodyTitle = bodyTitle;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
