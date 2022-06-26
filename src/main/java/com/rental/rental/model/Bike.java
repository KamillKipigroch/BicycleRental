package com.rental.rental.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;

    @OneToOne(mappedBy = "bike")
    private Station station;

    public Bike(){}
    public Bike(String make, String model){
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString(){
        return  String.format(
                "Bike[id=%d, make='%s', model='%s']",
                id, make, model);
    }

    public Long getId(){
        return  this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getMake(){
        return this.make;
    }
    public void setMake(String brand){
        this.make = brand;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String model){
        this.model = model;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return  true;
        if(!(o instanceof Bike bike))
            return  false;
        return Objects.equals(this.id, bike.id) && Objects.equals(this.make, bike.make) && Objects.equals(this.model, bike.model);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.make, this.model);
    }
}
