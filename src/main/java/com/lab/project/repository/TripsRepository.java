package com.lab.project.repository;

import com.lab.project.model.Trips;
import org.springframework.data.repository.CrudRepository;


public interface TripsRepository extends CrudRepository<Trips, Integer> {
}
