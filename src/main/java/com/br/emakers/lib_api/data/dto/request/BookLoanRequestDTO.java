package com.br.emakers.lib_api.data.dto.request;

import jakarta.validation.constraints.NotNull;

public record BookLoanRequestDTO(

    @NotNull(message = "A book id is required")
    Long bookId,

    @NotNull(message = "A person id is required")
    Long personId
) {
}
