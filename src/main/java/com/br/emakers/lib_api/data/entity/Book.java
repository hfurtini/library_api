package com.br.emakers.lib_api.data.entity;

import java.time.LocalDate;

import com.br.emakers.lib_api.data.dto.request.BookRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @Builder
    public Book(BookRequestDTO bookResquestDTO) {
        this.name = bookResquestDTO.name();
        this.author = bookResquestDTO.author();
        this.releaseDate = bookResquestDTO.releaseDate();
    }
}
