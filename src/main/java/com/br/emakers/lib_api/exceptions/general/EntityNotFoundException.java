package com.br.emakers.lib_api.exceptions.general;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Long id){
        super("Entity not found with id: " + id + ".");
    }
}
