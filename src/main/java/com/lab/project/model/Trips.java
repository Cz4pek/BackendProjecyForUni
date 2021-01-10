package com.lab.project.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Trips {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        @NotNull
        private String img_url;
        @NotNull
        private String title;
        @NotNull
        private String summary;
        @NotNull
        private String bodytitle;
        @NotNull
        private String info;
        @NotNull
        private String price;
        @NotNull
        private String category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBodytitle() {
        return bodytitle;
    }

    public void setBodytitle(String bodytitle) {
        this.bodytitle = bodytitle;
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
