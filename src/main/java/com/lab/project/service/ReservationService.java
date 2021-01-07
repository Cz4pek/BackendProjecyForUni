package com.lab.project.service;

import com.lab.project.auth.AppUser;
import com.lab.project.model.ReservationData;
import com.lab.project.model.User;
import com.lab.project.repository.ReservationsRepository;
import com.lab.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationsRepository reservationsRepository;
    @Autowired
    private UserRepository userRepository;

    public void addReservation(ReservationData reservationData) throws UsernameNotFoundException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> userCheck  = userRepository.findByUsername(
                ((AppUser)auth.getPrincipal())
                        .getUsername());
        userCheck.orElseThrow(() ->new UsernameNotFoundException("Nie ma zalogowanego użytkownika"));
        User user = userRepository.findByUsername(((AppUser)auth.getPrincipal()).getUsername()).get();
        reservationData.setUser_id(user);
        reservationsRepository.save(reservationData);
    }

}
