package com.lab.project.repository;

import com.lab.project.model.Trips;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripsRepository extends CrudRepository<Trips, Integer> {
}
