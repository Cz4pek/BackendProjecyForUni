package com.lab.project.service;

import com.google.common.collect.Iterables;
import com.lab.project.model.Trips;
import com.lab.project.repository.TripsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManagerFactory;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

@Service
public class TripsService {

    @Autowired
    private TripsRepository tripsRepository;


    public Trips[] getTripsFrom(String category) {

        Trips[] trips = tripsRepository.getAllByCategory(category).toArray(Trips[]::new);
        return trips;

    }



    public void addNewOffer(Trips trip) {
        tripsRepository.save(trip);
    }

    public Trips[] getAllAvailableOffers(){

        return Iterables.toArray(tripsRepository.findAll(), Trips.class);
    }


    public void deleteOffer(int id) {
        tripsRepository.deleteById(id);
    }

    public String getTripCategoryById(int offerId) {
        return tripsRepository.getTripsById(offerId).getCategory();
    }
}
