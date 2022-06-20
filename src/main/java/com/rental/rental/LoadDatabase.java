package com.rental.rental;

import com.rental.rental.model.Bike;
import com.rental.rental.model.Station;
import com.rental.rental.repository.BikeRepository;
import com.rental.rental.repository.StationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BikeRepository bikeRepository, StationRepository stationRepository){

        return args -> {
            log.info("Preloading " + bikeRepository.save(new Bike("Radon", "Jealous AL 9.0 MS")));
            log.info("Preloading " + bikeRepository.save(new Bike("Cube", "Stereo Hybrid 120 TM 750 29 flashgrey´n´olive")));
            log.info("Preloading " + stationRepository.save(new Station(null)));
            log.info("Preloading " + stationRepository.save(new Station(null)));
        };
    }
}
