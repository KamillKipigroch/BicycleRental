package com.rental.rental.exception;

public class StationNotFoundException extends  RuntimeException{
    StationNotFoundException(Long id){
        super("Could not find station " + id);
    }
}
