
package com.rental.rental.soap.courses;

import com.rental.rental.model.Bike;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public GetResponse createGetResponse() {
        return new GetResponse();
    }

    public Bike createBike() {
        return new Bike();
    }

    public GetBike createGetBike() {
        return new GetBike();
    }

}
