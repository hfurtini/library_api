package com.br.emakers.lib_api.service;

import com.br.emakers.lib_api.data.dto.request.PersonRequestDTO;
import com.br.emakers.lib_api.data.dto.response.PersonResponseDTO;
import com.br.emakers.lib_api.data.entity.Person;
import com.br.emakers.lib_api.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonResponseDTO> getAllPersons(){
        List<Person> persons = personRepository.findAll();

        return persons.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public PersonResponseDTO getPersonById(Long personId){
        Person person = getPersonEntityById(personId);

        return new PersonResponseDTO(person);
    }

    public PersonResponseDTO registerPerson(PersonRequestDTO personRequestDTO){
        Person person = Person.builder()
                .name(personRequestDTO.name())
                .cpf(personRequestDTO.cpf())
                .cep(personRequestDTO.cep())
                .email(personRequestDTO.email())
                .password(personRequestDTO.password())
                .build();

        Person savedPerson = personRepository.save(person);
        return new PersonResponseDTO(savedPerson);
    }

    public PersonResponseDTO updatePerson(Long personId, PersonRequestDTO personRequestDTO){
        Person person = getPersonEntityById(personId);

        person.setName(personRequestDTO.name());
        personRepository.save(person);

        person.setCep(personRequestDTO.cep());
        personRepository.save(person);

        person.setCpf(personRequestDTO.cpf());
        personRepository.save(person);

        person.setEmail(personRequestDTO.email());
        personRepository.save(person);

        person.setPassword(personRequestDTO.password());
        personRepository.save(person);

        return new PersonResponseDTO(person);
    }

    public String deletePerson(Long personId){
        Person person = getPersonEntityById(personId);

        personRepository.deleteById(personId);

        return "Person: " + person.getName() + " deleted.";
    }

    private Person getPersonEntityById(Long personId){
        return personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person not found"));
    }
}
