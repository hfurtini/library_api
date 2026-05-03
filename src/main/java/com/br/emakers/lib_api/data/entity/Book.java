package com.br.emakers.lib_api.data.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long book_id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "release_date")
    private LocalDate release_date;

}
