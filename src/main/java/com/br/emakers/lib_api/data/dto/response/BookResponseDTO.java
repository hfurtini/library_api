package com.br.emakers.lib_api.data.dto.response;

import com.br.emakers.lib_api.data.entity.Book;

import java.time.LocalDate;

public record BookResponseDTO(

        Long bookId,
        String name,
        String author,
        LocalDate releaseDate
) {
    public BookResponseDTO(Book book){
        this(
                book.getBookId(),
                book.getName(),
                book.getAuthor(),
                book.getReleaseDate()
        );
    }
}
