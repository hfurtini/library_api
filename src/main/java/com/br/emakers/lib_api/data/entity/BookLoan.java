package com.br.emakers.lib_api.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_loan")
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;

    @ManyToOne()
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

}
