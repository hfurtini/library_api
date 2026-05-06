package com.br.emakers.lib_api.data.dto.response;

import com.br.emakers.lib_api.data.entity.Person;

public record PersonResponseDTO(

        Long personId,
        String name,
        String cpf,
        String cep,
        String email,
        String password
) {
    public PersonResponseDTO(Person person){
        this(
                person.getPersonId(),
                person.getName(),
                person.getCpf(),
                person.getCep(),
                person.getEmail(),
                person.getPassword()
        );
    }
}
