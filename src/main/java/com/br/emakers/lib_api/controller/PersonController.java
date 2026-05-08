package com.br.emakers.lib_api.controller;

import com.br.emakers.lib_api.data.dto.request.PersonRequestDTO;
import com.br.emakers.lib_api.data.dto.response.PersonResponseDTO;
import com.br.emakers.lib_api.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PersonResponseDTO>> getAllPersons(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
    }

    @GetMapping(value = "/{personId}")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable Long personId){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(personId));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PersonResponseDTO> registerPerson(@RequestBody PersonRequestDTO personRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(personService.registerPerson(personRequestDTO));
    }

    @PutMapping(value = "/update/{personId}")
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable Long personId ,@RequestBody PersonRequestDTO personRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(personId, personRequestDTO));
    }

    @DeleteMapping(value = "/delete/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable Long personId){
        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(personId));
    }
}
