package com.lab.project.service;

import com.lab.project.model.ReservationData;
import com.lab.project.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    public void addReservation(ReservationData reservationData){

        reservationsRepository.save(reservationData);
    }

}
