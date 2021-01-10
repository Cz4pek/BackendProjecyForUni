package com.lab.project.service;

import com.lab.project.auth.AppUser;
import com.lab.project.model.ReservationData;
import com.lab.project.model.Trips;
import com.lab.project.model.User;
import com.lab.project.repository.ReservationsRepository;
import com.lab.project.repository.TripsRepository;
import com.lab.project.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationsRepository reservationsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TripsRepository tripsRepository;



    public void addReservation(ReservationData reservationData) throws UsernameNotFoundException{

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> userCheck  = userRepository.findByUsername(
                ((AppUser)auth.getPrincipal())
                        .getUsername());
        userCheck.orElseThrow(() ->new UsernameNotFoundException("Nie ma zalogowanego użytkownika"));
        User user =  userCheck.get();
        reservationData.setUser_id(user);

        Trips trip = tripsRepository.getTripsById(Integer.parseInt(reservationData.getWycieczka()));

        reservationData.setTrip(trip);
        reservationsRepository.save(reservationData);
    }




}
