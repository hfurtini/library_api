package com.br.emakers.lib_api.service;

import com.br.emakers.lib_api.data.dto.request.PersonRequestDTO;
import com.br.emakers.lib_api.data.dto.response.PersonResponseDTO;
import com.br.emakers.lib_api.data.dto.response.ViaCepResponseDTO;
import com.br.emakers.lib_api.data.entity.Person;
import com.br.emakers.lib_api.exception.general.EntityNotFoundException;
import com.br.emakers.lib_api.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final ViaCepService viaCepService;

    public List<PersonResponseDTO> getAllPersons(){
        List<Person> persons = personRepository.findAll();

        return persons.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public PersonResponseDTO getPersonById(Long personId){
        Person person = getPersonEntityById(personId);

        return new PersonResponseDTO(person);
    }

    public PersonResponseDTO registerPerson(PersonRequestDTO personRequestDTO){
        String encryptedPassword = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(personRequestDTO.password());

        Person person = Person.builder()
                .name(personRequestDTO.name())
                .cpf(personRequestDTO.cpf())
                .cep(personRequestDTO.cep())
                .email(personRequestDTO.email())
                .password(encryptedPassword)
                .build();

        Person savedPerson = personRepository.save(person);
        ViaCepResponseDTO address = viaCepService.getAddressByCep(personRequestDTO.cep());
        return new PersonResponseDTO(savedPerson, address);
    }

    public PersonResponseDTO updatePerson(Long personId, PersonRequestDTO personRequestDTO){
        Person person = getPersonEntityById(personId);

        String encryptedPassword = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(personRequestDTO.password());

        person.setName(personRequestDTO.name());
        person.setCep(personRequestDTO.cep());
        person.setCpf(personRequestDTO.cpf());
        person.setEmail(personRequestDTO.email());
        person.setPassword(encryptedPassword);

        personRepository.save(person);

        ViaCepResponseDTO addres = viaCepService.getAddressByCep(personRequestDTO.cep());
        return new PersonResponseDTO(person);
    }

    public String deletePerson(Long personId){
        Person person = getPersonEntityById(personId);

        personRepository.deleteById(personId);

        return "Person: " + person.getName() + " deleted.";
    }

    private Person getPersonEntityById(Long personId){
        return personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException(personId));
    }
}
