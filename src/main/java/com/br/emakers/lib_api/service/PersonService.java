package com.br.emakers.lib_api.service;

import com.br.emakers.lib_api.data.dto.response.PersonResponseDTO;
import com.br.emakers.lib_api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonResponseDTO> getAllPersons(){
        return null;
    }

    public PersonResponseDTO getPersonById(){
        return null;
    }

    public PersonResponseDTO registerPerson(){
        return null;
    }

    public PersonResponseDTO updatePerson(){
        return null;
    }

    public PersonResponseDTO deletePerson(){
        return null;
    }
}
