package com.lab.project.service;

import com.google.common.collect.Iterables;
import com.lab.project.auth.AppUser;
import com.lab.project.model.*;
import com.lab.project.repository.ReservationsRepository;
import com.lab.project.repository.TripsRepository;
import com.lab.project.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserPageService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservationsRepository reservationsRepository;
    @Autowired
    TripsRepository tripsRepository;

    private SessionFactory hibernateFactory;

    @Autowired
    public void setFactory(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }



    private Optional<User> getLoggedInUser() throws UsernameNotFoundException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> userCheck  = userRepository.findByUsername(
                ((AppUser)auth.getPrincipal())
                        .getUsername());
        userCheck.orElseThrow(() ->new UsernameNotFoundException("Nie ma zalogowanego użytkownika"));
        return userCheck;
    }

    public User getUserPage(){
        Optional<User> userCheck = getLoggedInUser();
        return userCheck.get();
    }

    public void changeUsersInfo(ChangedUserInfo changedUserInfo){

        Optional<User> userCheck = getLoggedInUser();
        User user = userCheck.get();
        String temp = changedUserInfo.getFirstname();
        if(temp != null) user.setFirstname(temp);
        temp = changedUserInfo.getLastname();
        if(temp != null) user.setLastname(temp);
        temp = changedUserInfo.getEmail();
        if(temp != null) user.setEmail(temp);

        userRepository.save(user);
//        Optional<User> userCheck = getLoggedInUser();
//        userCheck.get();
    }


    public void deleteCurrentlyLoggedInUser() {

        Optional<User> userCheck = getLoggedInUser();
        User user = userCheck.get();

        Session session = hibernateFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE FROM ReservationData E where E.user = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", user);

        int count = query.executeUpdate();
        System.out.println(count + " Record(s) Deleted.");


        transaction.commit();
        session.clear();
        session.close();

        userRepository.delete(user);

    }
    public UsersReservation[] getTripsReservedByUser(){
        try {
            Optional<User> userCheck = getLoggedInUser();
            ReservationData[] reservationsByUser = reservationsRepository.getByUser(userCheck.get()).toArray(ReservationData[]::new);
            List<Trips> trips = Arrays.stream(reservationsByUser).map(ReservationData::getTrip).collect(Collectors.toList());
            Trips[] allTrips = trips.toArray(Trips[]::new);
            ArrayList<UsersReservation> reservations = new ArrayList<>();
            for (int i = 0; i < allTrips.length; i++){
                reservations.add(new UsersReservation(allTrips[i], reservationsByUser[i]));
            }
            return reservations.toArray(UsersReservation[]::new);
        }
        catch (UsernameNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
