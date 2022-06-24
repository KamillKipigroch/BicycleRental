
package com.rental.rental.soap.station;

import com.rental.rental.model.Bike;
import com.rental.rental.model.Station;
import com.rental.rental.soap.station.add.AddStationRequest;
import com.rental.rental.soap.station.add.AddStationResponse;
import com.rental.rental.soap.station.delete.DeleteStationRequest;
import com.rental.rental.soap.station.delete.DeleteStationResponse;
import com.rental.rental.soap.station.edit.EditStationRequest;
import com.rental.rental.soap.station.edit.EditStationResponse;
import com.rental.rental.soap.station.get.GetStationRequest;
import com.rental.rental.soap.station.get.GetStationResponse;
import com.rental.rental.soap.station.bike.rent.RentBikeRequest;
import com.rental.rental.soap.station.bike.rent.RentBikeResponse;
import com.rental.rental.soap.station.bike.returnb.ReturnBikeRequest;
import com.rental.rental.soap.station.bike.returnb.ReturnBikeResponse;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rental.rental.soap.courses.station package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rental.rental.soap.courses.station
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStationRequest }
     * 
     */
    public AddStationRequest createAddStationRequest() {
        return new AddStationRequest();
    }

    /**
     * Create an instance of {@link Bike }
     * 
     */
    public Bike createBike() {
        return new Bike();
    }

    /**
     * Create an instance of {@link AddStationResponse }
     * 
     */
    public AddStationResponse createAddStationResponse() {
        return new AddStationResponse();
    }

    /**
     * Create an instance of {@link Station }
     * 
     */
    public Station createStation() {
        return new Station();
    }

    /**
     * Create an instance of {@link GetStationRequest }
     * 
     */
    public GetStationRequest createGetStationRequest() {
        return new GetStationRequest();
    }

    /**
     * Create an instance of {@link GetStationResponse }
     * 
     */
    public GetStationResponse createGetStationResponse() {
        return new GetStationResponse();
    }

    /**
     * Create an instance of {@link DeleteStationRequest }
     * 
     */
    public DeleteStationRequest createDeleteStationRequest() {
        return new DeleteStationRequest();
    }

    /**
     * Create an instance of {@link DeleteStationResponse }
     * 
     */
    public DeleteStationResponse createDeleteStationResponse() {
        return new DeleteStationResponse();
    }

    /**
     * Create an instance of {@link EditStationRequest }
     * 
     */
    public EditStationRequest createEditStationRequest() {
        return new EditStationRequest();
    }

    /**
     * Create an instance of {@link EditStationResponse }
     * 
     */
    public EditStationResponse createEditStationResponse() {
        return new EditStationResponse();
    }

    /**
     * Create an instance of {@link RentBikeRequest }
     * 
     */
    public RentBikeRequest createRentBikeRequest() {
        return new RentBikeRequest();
    }

    /**
     * Create an instance of {@link RentBikeResponse }
     * 
     */
    public RentBikeResponse createRentBikeResponse() {
        return new RentBikeResponse();
    }

    /**
     * Create an instance of {@link ReturnBikeRequest }
     * 
     */
    public ReturnBikeRequest createReturnBikeRequest() {
        return new ReturnBikeRequest();
    }

    /**
     * Create an instance of {@link ReturnBikeResponse }
     * 
     */
    public ReturnBikeResponse createReturnBikeResponse() {
        return new ReturnBikeResponse();
    }

}
