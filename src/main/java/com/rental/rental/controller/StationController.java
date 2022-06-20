package com.rental.rental.controller;

import com.rental.rental.model.Station;
import com.rental.rental.repository.StationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationController {
    private final StationRepository repository;

    StationController(StationRepository repository){
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

    @PutMapping
    Station replaceStation(@RequestBody Station newStation, @PathVariable Long id){
        return  repository.findById(id)
                .map(station -> {
                    station.setBike(newStation.getBike());
                    return repository.save((station));
                })
                .orElseGet(() -> {
                    newStation.setId(id);
                    return repository.save((newStation));
                });
    }

    @DeleteMapping("/station/{id}")
    void deleteStation(@PathVariable Long id){
        repository.deleteById(id);
    }

}
