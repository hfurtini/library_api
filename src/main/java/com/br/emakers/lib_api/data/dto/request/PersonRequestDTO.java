package com.br.emakers.lib_api.data.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PersonRequestDTO(

        @NotBlank(message = "Your name is required")
        String name,

        @NotBlank(message = "Your CPF is required")
        String cpf,

        String cep,

        @NotBlank(message = "Your email is required")
        String email,

        @NotBlank(message = "A password is required")
        String password


) {
}
