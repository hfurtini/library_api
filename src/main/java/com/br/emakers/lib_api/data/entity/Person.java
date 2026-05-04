package com.br.emakers.lib_api.data.entity;

import com.br.emakers.lib_api.data.dto.request.PersonRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(name = "cep", length = 9)
    private String cep;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Builder
    public Person(PersonRequestDTO personRequestDTO){
        this.name = personRequestDTO.name();
        this.cpf = personRequestDTO.cpf();
        this.cep = personRequestDTO.cep();
        this.email = personRequestDTO.email();
        this.password = personRequestDTO.password();
    }
}
