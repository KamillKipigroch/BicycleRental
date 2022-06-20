package com.rental.rental.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;

    @OneToOne(mappedBy = "bike")
    private Station station;

    protected  Bike (){}
    public Bike(String make, String model){
        this.brand = make;
        this.model = model;
    }

    @Override
    public String toString(){
        return  String.format(
                "Bike[id=%d, make='%s', model='%s']",
                id, brand, model);
    }

    public Long getId(){
        return  this.id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
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
        return Objects.equals(this.id, bike.id) && Objects.equals(this.brand, bike.brand) && Objects.equals(this.model, bike.model);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.brand, this.model);
    }
}
