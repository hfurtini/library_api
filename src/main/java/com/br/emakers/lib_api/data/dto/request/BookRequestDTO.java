package com.br.emakers.lib_api.data.dto.request;


import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record BookRequestDTO(
        @NotBlank(message = "Book name is required")
        String name,

        @NotBlank(message = "Author name is required")
        String author,

        LocalDate releaseDate
) {
}
