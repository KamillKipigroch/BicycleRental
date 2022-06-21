package com.rental.rental.exceptions;

public class BikeNotFoundException extends  RuntimeException{
    BikeNotFoundException(Long id){
        super("Could not find bike " + id);
    }
}
