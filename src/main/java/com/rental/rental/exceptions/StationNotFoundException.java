package com.rental.rental.exceptions;

public class StationNotFoundException extends  RuntimeException{
    StationNotFoundException(Long id){
        super("Could not find station " + id);
    }
}
