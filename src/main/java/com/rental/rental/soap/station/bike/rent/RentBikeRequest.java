
package com.rental.rental.soap.station.bike.rent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="idStation" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "idStation"
})
@XmlRootElement(name = "RentBikeRequest", namespace = "https://rental-bike.pl/soap/station")
public class RentBikeRequest {

    protected long idStation;

    /**
     * Gets the value of the idStation property.
     * 
     */
    public long getIdStation() {
        return idStation;
    }

    /**
     * Sets the value of the idStation property.
     * 
     */
    public void setIdStation(long value) {
        this.idStation = value;
    }

}
