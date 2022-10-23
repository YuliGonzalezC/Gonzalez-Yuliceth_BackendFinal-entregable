package com.example.clinica.exceptions;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException (String mensaje){
        super(mensaje);
    }
}
