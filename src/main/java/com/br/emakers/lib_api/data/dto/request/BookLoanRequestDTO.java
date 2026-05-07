package com.br.emakers.lib_api.data.dto.request;

import jakarta.validation.constraints.NotBlank;

public record BookLoanRequestDTO(

    @NotBlank(message = "A book id is required")
    Long bookId,

    @NotBlank(message = "A person id is required")
    Long personID
) {
}
