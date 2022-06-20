package com.rental.rental.repository;

import com.rental.rental.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, Long>{

}
