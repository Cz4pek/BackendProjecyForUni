package com.lab.project.repository;

import com.lab.project.model.Trips;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripsRepository extends CrudRepository<Trips, Integer> {

    Trips getTripsById(int id);
    List<Trips> getAllByCategory(String category);

}
