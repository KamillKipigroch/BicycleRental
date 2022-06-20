package com.rental.rental.model;

import javax.persistence.*;
import java.util.Objects;
import com.rental.rental.model.Bike;

@Entity
@Table(name = "Station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bike_id", referencedColumnName = "id")
    private Bike bike;

    protected  Station (){}
    public Station(Bike bike){
        this.bike = bike;
    }

    @Override
    public String toString(){
        return  String.format(
                "Station[id=%d, bike=%s]",
                id, Objects.toString(bike, "isEmpty"));
    }

    public Long getId(){
        return  this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Bike getBike() {
        return bike;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return  true;
        if(!(o instanceof Station station))
            return  false;
        return Objects.equals(this.id, station.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.bike);
    }
}
