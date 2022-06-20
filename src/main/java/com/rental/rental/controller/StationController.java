package com.rental.rental.controller;

import com.rental.rental.model.Bike;
import com.rental.rental.model.Station;
import com.rental.rental.repository.BikeRepository;
import com.rental.rental.repository.StationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StationController {
    private final StationRepository repository;
    private final BikeRepository bikeRepository;

    StationController(StationRepository repository,BikeRepository bikeRepository){
        this.bikeRepository = bikeRepository;
        this.repository = repository;
    }

    @GetMapping("/stations")
    List<Station> all(){
        return  repository.findAll();
    }

    @PostMapping("/stations")
    Station newStation(@RequestBody Station newStation){
        return repository.save(newStation);
    }

    @DeleteMapping("/station/{id}")
    void deleteStation(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/station/{id}/rent-bike")
    Optional<Station> rentBike(@PathVariable Long id){
        return  repository.findById(id)
                .filter(station -> station.getBike() != null)
                .map(station -> {
                        station.setBike(null);
                        return repository.save(station);
                });
    }

    @PutMapping("/station/{id}/return-bike/{idBike}")
    Optional<Station> returnBike(@PathVariable Long id, @PathVariable Long idBike){
        Bike bike = bikeRepository.findById(idBike).orElse(null);
        return  repository.findById(id)
                .filter(station -> station.getBike() == null)
                .map(station -> {
                    station.setBike(bike);
                    return repository.save(station);
                });
    }
}
