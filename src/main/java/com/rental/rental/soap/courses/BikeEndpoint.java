package com.rental.rental.soap.courses;

import com.rental.rental.model.Bike;
import com.rental.rental.repository.BikeRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BikeEndpoint {

    private BikeRepository bikeRepository;

    public BikeEndpoint(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @PayloadRoot(namespace = "http://rental-bike.pl/soup", localPart = "getBike")
    @ResponsePayload
    public GetResponse getBikeById(@RequestPayload GetBike getBike) {
        Bike bikeById = bikeRepository.findById(getBike.getId()).orElse(null);
        GetResponse getResponse = new GetResponse();
        getResponse.setBike(bikeById);
        return getResponse;
    }

//    @PayloadRoot(namespace = "http://rental-bike.pl/soup", localPart = "setBike")
//    @ResponsePayload
//    public GetResponse setBikeById(@RequestPayload SetBike setBike) {
//        GetResponse getResponse = new GetResponse();
//        bikeRepository.findById(setBike.getId())
//                .map(bike -> {
//                    bike.setBrand(setBike.getBrand());
//                    bike.setModel(setBike.getModel());
//                    bikeRepository.save(bike);
//                    getResponse.setBike(bike);
//                    return getResponse;
//                })
//                .orElseGet(() -> {
//                    newBike.setId(id);
//                    return repository.save((newBike));
//                });
//    }

}
