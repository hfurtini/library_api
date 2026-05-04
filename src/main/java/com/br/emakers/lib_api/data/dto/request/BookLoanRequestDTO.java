package com.br.emakers.lib_api.data.dto.request;

public record BookLoanRequestDTO(
    Long bookId,
    Long personID
) {
}
