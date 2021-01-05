package com.lab.project.service;

import com.lab.project.model.Trip;
import com.lab.project.repository.TripsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManagerFactory;
import org.hibernate.query.Query;
import java.util.List;

@Service
public class TripsService {

    @Autowired
    private TripsRepository tripsRepository;

    private SessionFactory hibernateFactory;

    @Autowired
    public void setFactory(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }


    public Trip[] getTripsFromWorld(){

        Session session = hibernateFactory.openSession();
        String hql = "FROM Trip E where E.category = 'swiat'";
        return getTrips(session, hql);
    }

    private Trip[] getTrips(Session session, String hql) {
        Query query = session.createQuery(hql);
        List results = query.list();
        Trip[] allTrips = new Trip[results.size()];
        for (int i = 0; i < results.size(); i++) {
            allTrips[i] = (Trip) results.get(i);
        }
        return allTrips;
    }

    public Trip[] getTripsFromCountry(){

        Session session = hibernateFactory.openSession();
        String hql = "FROM Trip E where E.category = 'kraj'";
        return getTrips(session, hql);
    }

    public Trip[] getTripsFromContinent(){

        Session session = hibernateFactory.openSession();
        String hql = "FROM Trip E where E.category = 'europa'";
        return getTrips(session, hql);
    }
}
