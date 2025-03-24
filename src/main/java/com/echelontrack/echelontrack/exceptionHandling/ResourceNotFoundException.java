package com.echelontrack.echelontrack.exceptionHandling;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}

