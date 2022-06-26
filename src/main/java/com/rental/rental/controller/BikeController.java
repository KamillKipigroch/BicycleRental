package com.rental.rental.controller;

import com.rental.rental.model.Bike;
import com.rental.rental.repository.BikeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {
    private final BikeRepository repository;

    BikeController(BikeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/bikes")
    List<Bike> all(){
        return  repository.findAll();
    }

    @PostMapping("/add-bike")
    Bike newBike(@RequestBody Bike newBike){
        return repository.save(newBike);
    }

    @PutMapping("/edit-bike/{id}")
    Bike editBike(@RequestBody Bike newBike, @PathVariable Long id){

        return  repository.findById(id)
                .map(bike -> {
                    bike.setMake(newBike.getMake());
                    bike.setModel(newBike.getModel());
                    return repository.save((bike));
                })
                .orElseGet(() -> {
                    newBike.setId(id);
                    return repository.save((newBike));
                });
    }

    @DeleteMapping("/bike/{id}")
    void deleteStation(@PathVariable Long id){
        repository.deleteById(id);
    }

}
