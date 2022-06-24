
package com.rental.rental.soap.station.add;

import com.rental.rental.model.Bike;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bike" type="{http://rental-bike.pl/soap/station}Bike"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bike"
})
@XmlRootElement(name = "AddStationRequest", namespace = "https://rental-bike.pl/soap/station")
public class AddStationRequest {

    @XmlElement(required = true)
    protected Bike bike;

    /**
     * Gets the value of the bike property.
     * 
     * @return
     *     possible object is
     *     {@link Bike }
     *     
     */
    public Bike getBike() {
        return bike;
    }

    /**
     * Sets the value of the bike property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bike }
     *     
     */
    public void setBike(Bike value) {
        this.bike = value;
    }

}
