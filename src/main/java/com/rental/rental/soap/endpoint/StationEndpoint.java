package com.rental.rental.soap.endpoint;

import com.rental.rental.model.Bike;
import com.rental.rental.model.Station;
import com.rental.rental.model.Status;
import com.rental.rental.repository.BikeRepository;
import com.rental.rental.repository.StationRepository;
import com.rental.rental.soap.bike.delete.DeleteBikeRequest;
import com.rental.rental.soap.bike.delete.DeleteBikeResponse;
import com.rental.rental.soap.station.add.AddStationRequest;
import com.rental.rental.soap.station.add.AddStationResponse;
import com.rental.rental.soap.station.edit.EditStationRequest;
import com.rental.rental.soap.station.edit.EditStationResponse;
import com.rental.rental.soap.station.get.GetStationRequest;
import com.rental.rental.soap.station.get.GetStationResponse;
import com.rental.rental.soap.station.bike.rent.RentBikeRequest;
import com.rental.rental.soap.station.bike.rent.RentBikeResponse;
import com.rental.rental.soap.station.bike.returnb.ReturnBikeRequest;
import com.rental.rental.soap.station.bike.returnb.ReturnBikeResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.rental.rental.model.Status.FAILURE;
import static com.rental.rental.model.Status.SUCCESS;

@Endpoint
public class StationEndpoint {
    private final BikeRepository bikeRepository;
    private final StationRepository stationRepository;

    public StationEndpoint(BikeRepository bikeRepository, StationRepository stationRepository) {
        this.bikeRepository = bikeRepository;
        this.stationRepository = stationRepository;
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/station", localPart = "AddStationRequest")
    @ResponsePayload
    public AddStationResponse addStation(@RequestPayload AddStationRequest request) {

        Bike newBike = new Bike(request.getBike().getMake(),request.getBike().getModel());
        bikeRepository.save(newBike);

        Station station = new Station(newBike);
        stationRepository.save(station);

        AddStationResponse response = new AddStationResponse();
        response.setStation(station);

        return response;
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/station", localPart = "GetStationRequest")
    @ResponsePayload
    public GetStationResponse getStationById(@RequestPayload GetStationRequest request) {

        Station stationById = stationRepository.findById(request.getId()).orElse(null);
        GetStationResponse getResponse = new GetStationResponse();
        getResponse.setStation(stationById);

        return getResponse;
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/station", localPart = "EditStationRequest")
    @ResponsePayload
    public EditStationResponse editStation(@RequestPayload EditStationRequest request) {

        EditStationResponse response = new EditStationResponse();

        return stationRepository.findById(request.getStation().getId())
                .map(station -> {
                    station.setBike(request.getStation().getBike());
                    stationRepository.save((station));

                    response.setStatus(mapStatus(SUCCESS));
                    return response;
                })
                .orElseGet(() -> {
                    Station newStation = new Station(request.getStation().getBike());
                    stationRepository.save((newStation));

                    response.setStatus(mapStatus(FAILURE));
                    return response;
                });
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/station", localPart = "DeleteStationRequest")
    @ResponsePayload
    public DeleteBikeResponse deleteCourseDetailsRequest(@RequestPayload DeleteBikeRequest request) {

        bikeRepository.deleteById(request.getId());

        DeleteBikeResponse response = new DeleteBikeResponse();
        response.setStatus(mapStatus(SUCCESS));

        return response;
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/station", localPart = "RentBikeRequest")
    @ResponsePayload
    public RentBikeResponse rentBike(@RequestPayload RentBikeRequest request) {
        RentBikeResponse response = new RentBikeResponse();
        return stationRepository.findById(request.getIdStation())
                .filter(station -> station.getBike() != null)
                .map(station -> {
                    response.setBike(station.getBike());
                    station.setBike(null);
                    stationRepository.save(station);
                    return  response;
                })
                .orElse(response);
    }

    @PayloadRoot(namespace = "https://rental-bike.pl/soap/station", localPart = "ReturnBikeRequest")
    @ResponsePayload
    public ReturnBikeResponse returnBike(@RequestPayload ReturnBikeRequest request) {

        ReturnBikeResponse response = new ReturnBikeResponse();

        Bike bike = bikeRepository.findById(request.getIdBike()).orElse(null);
        return stationRepository.findById(request.getIdStation())
                .filter(station -> station.getBike() == null)
                .map(station -> {
                    station.setBike(bike);
                    stationRepository.save(station);
                    response.setStation(station);

                    return  response;
                })
                .orElse(response);
    }

    private Status mapStatus(Status status) {
        if (status == Status.FAILURE)
            return Status.FAILURE;
        return Status.SUCCESS;
    }

}
