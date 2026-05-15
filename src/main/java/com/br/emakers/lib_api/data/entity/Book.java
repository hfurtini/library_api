package com.br.emakers.lib_api.data.entity;

import java.time.LocalDate;

import com.br.emakers.lib_api.data.dto.request.BookRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "is_available", columnDefinition = "boolean default true")
    private Boolean isAvailable = true;

    public Book(BookRequestDTO bookRequestDTO) {
        this.name = bookRequestDTO.name();
        this.author = bookRequestDTO.author();
        this.releaseDate = bookRequestDTO.releaseDate();
    }

}


