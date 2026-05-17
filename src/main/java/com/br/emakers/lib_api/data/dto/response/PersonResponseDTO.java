package com.br.emakers.lib_api.data.dto.response;

import com.br.emakers.lib_api.data.entity.Person;

public record PersonResponseDTO(
        Long personId,
        String name,
        String cpf,
        String cep,
        String email,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {
    public PersonResponseDTO(Person person) {
        this(
                person.getPersonId(),
                person.getName(),
                person.getCpf(),
                person.getCep(),
                person.getEmail(),
                null,
                null,
                null,
                null
        );
    }

    public PersonResponseDTO(Person person, ViaCepResponseDTO address) {
        this(
                person.getPersonId(),
                person.getName(),
                person.getCpf(),
                person.getCep(),
                person.getEmail(),
                address.logradouro(),
                address.bairro(),
                address.localidade(),
                address.uf()
        );
    }
}
