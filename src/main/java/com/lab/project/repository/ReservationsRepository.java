package com.lab.project.repository;

import com.lab.project.model.ReservationData;
import com.lab.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends CrudRepository<ReservationData, Integer> {

    List<ReservationData> getByUser(User user);

}
