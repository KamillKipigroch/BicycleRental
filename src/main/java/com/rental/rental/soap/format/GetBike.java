
package com.rental.rental.soap.format;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id"
})
@XmlRootElement(name = "getBike", namespace = "http://rental-bike.pl/soup")
public class GetBike {

    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

}
