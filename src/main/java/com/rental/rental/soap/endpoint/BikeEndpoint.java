package com.rental.rental.soap.endpoint;

import com.rental.rental.model.Bike;
import com.rental.rental.repository.BikeRepository;
import com.rental.rental.soap.format.GetBike;
import com.rental.rental.soap.format.GetResponse;
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
    public GetResponse getStudentById(@RequestPayload GetBike getBike) {
        Bike bikeById = bikeRepository.findById(getBike.getId()).orElse(null);
        GetResponse getResponse = new GetResponse();
        getResponse.setBike(bikeById);
        return getResponse;
    }
}
