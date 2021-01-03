package com.lab.project.service;

import com.lab.project.model.Trips;
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


    public Trips[] getTripsFromWorld(){

        Session session = hibernateFactory.openSession();
        String hql = "FROM Trips E where E.category = 'swiat'";
        return getTrips(session, hql);
    }

    private Trips[] getTrips(Session session, String hql) {
        Query query = session.createQuery(hql);
        List results = query.list();
        Trips [] allTrips = new Trips[results.size()];
        for (int i = 0; i < results.size(); i++) {
            allTrips[i] = (Trips) results.get(i);
        }
        return allTrips;
    }

    public Trips[] getTripsFromCountry(){

        Session session = hibernateFactory.openSession();
        String hql = "FROM Trips E where E.category = 'kraj'";
        return getTrips(session, hql);
    }

    public Trips[] getTripsFromContinent(){

        Session session = hibernateFactory.openSession();
        String hql = "FROM Trips E where E.category = 'europa'";
        return getTrips(session, hql);
    }
}
