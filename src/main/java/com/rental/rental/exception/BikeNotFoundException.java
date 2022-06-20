package com.rental.rental.exception;

public class BikeNotFoundException extends  RuntimeException{
    BikeNotFoundException(Long id){
        super("Could not find bike " + id);
    }
}
