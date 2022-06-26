package com.rental.rental.soap.endpoint;

import com.rental.rental.model.Bike;
import com.rental.rental.model.Status;
import com.rental.rental.repository.BikeRepository;
import com.rental.rental.soap.bike.add.AddBikeRequest;
import com.rental.rental.soap.bike.add.AddBikeResponse;
import com.rental.rental.soap.bike.delete.DeleteBikeRequest;
import com.rental.rental.soap.bike.delete.DeleteBikeResponse;
import com.rental.rental.soap.bike.edit.EditBikeRequest;
import com.rental.rental.soap.bike.edit.EditBikeResponse;
import com.rental.rental.soap.bike.get.GetBikeRequest;
import com.rental.rental.soap.bike.get.GetBikeResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.rental.rental.model.Status.FAILURE;
import static com.rental.rental.model.Status.SUCCESS;

@Endpoint
public class BikeEndpoint {
    private final BikeRepository bikeRepository;

    public BikeEndpoint(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/bike", localPart = "AddBikeRequest")
    @ResponsePayload
    public AddBikeResponse addBike(@RequestPayload AddBikeRequest request) {

        Bike bike = new Bike(request.getMake(), request.getModel());
        bikeRepository.save(bike);
        AddBikeResponse response = new AddBikeResponse();
        response.setBike(bike);

        return response;
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/bike", localPart = "GetBikeRequest")
    @ResponsePayload
    public GetBikeResponse getBikeById(@RequestPayload GetBikeRequest request) {

        Bike bikeById = bikeRepository.findById(request.getId()).orElse(null);
        GetBikeResponse getResponse = new GetBikeResponse();
        getResponse.setBike(bikeById);

        return getResponse;
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/bike", localPart = "EditBikeRequest")
    @ResponsePayload
    public EditBikeResponse editBikeById(@RequestPayload EditBikeRequest request) {

        EditBikeResponse response = new EditBikeResponse();

        return bikeRepository.findById(request.getBike().getId())
                .map(bike -> {
                    bike.setMake(request.getBike().getMake());
                    bike.setModel(request.getBike().getModel());
                    bikeRepository.save(bike);

                    response.setStatus(mapStatus(SUCCESS));

                    return response;
                })
                .orElseGet(() -> {
                    bikeRepository.save(request.getBike());

                    response.setStatus(mapStatus(FAILURE));

                    return response;
                });
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/bike", localPart = "DeleteBikeRequest")
    @ResponsePayload
    public DeleteBikeResponse deleteCourseDetailsRequest(@RequestPayload DeleteBikeRequest request) {

        bikeRepository.deleteById(request.getId());

        DeleteBikeResponse response = new DeleteBikeResponse();
        response.setStatus(mapStatus(SUCCESS));

        return response;
    }

    private com.rental.rental.model.Status mapStatus(Status status) {
        if (status == Status.FAILURE)
            return com.rental.rental.model.Status.FAILURE;
        return com.rental.rental.model.Status.SUCCESS;
    }

}
