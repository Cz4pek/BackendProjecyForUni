package com.lab.project.repository;

import com.lab.project.model.ReservationData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends CrudRepository<ReservationData, Integer> {
}
