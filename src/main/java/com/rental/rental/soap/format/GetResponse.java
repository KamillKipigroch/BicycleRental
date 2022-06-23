
package com.rental.rental.soap.format;

import com.rental.rental.model.Bike;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bike"
})
@XmlRootElement(name = "getResponse", namespace = "http://rental-bike.pl/soup")
public class GetResponse {

    @XmlElement(required = true)
    protected Bike bike;

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike value) {
        this.bike = value;
    }

}
