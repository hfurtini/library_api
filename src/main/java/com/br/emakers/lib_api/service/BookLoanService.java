package com.br.emakers.lib_api.service;

import com.br.emakers.lib_api.data.dto.request.BookLoanRequestDTO;
import com.br.emakers.lib_api.data.dto.response.BookLoanResponseDTO;
import com.br.emakers.lib_api.data.entity.BookLoan;
import com.br.emakers.lib_api.data.entity.Person;
import com.br.emakers.lib_api.data.entity.Book;
import com.br.emakers.lib_api.exception.general.EntityNotFoundException;
import com.br.emakers.lib_api.repository.BookLoanRepository;
import com.br.emakers.lib_api.repository.BookRepository;
import com.br.emakers.lib_api.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookLoanService {

    private final BookLoanRepository bookLoanRepository;
    private final BookRepository bookRepository;
    private final PersonRepository personRepository;

    public List<BookLoanResponseDTO> getAllLoans(){
        List<BookLoan> booksLoan = bookLoanRepository.findAll();

        return booksLoan.stream().map(BookLoanResponseDTO::new).collect(Collectors.toList());
    }

    public BookLoanResponseDTO getLoanById(Long loanId){
        BookLoan bookLoan = getBookLoanById(loanId);

        return new BookLoanResponseDTO(bookLoan);
    }

    public BookLoanResponseDTO createBookLoan(BookLoanRequestDTO bookLoanRequestDTO){
        Book book = bookRepository.findById(bookLoanRequestDTO.bookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Person person = personRepository.findById(bookLoanRequestDTO.personId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        BookLoan loanId = BookLoan.builder()
                .book(book)
                .person(person)
                .build();

        BookLoan savedLoan = bookLoanRepository.save(loanId);
        return new BookLoanResponseDTO(savedLoan);
    }

    public BookLoanResponseDTO updateLoan(Long loanId, BookLoanRequestDTO bookLoanRequestDTO){
        BookLoan bookLoan = getBookLoanById(loanId);

        Book book = bookRepository.findById(bookLoanRequestDTO.bookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Person person = personRepository.findById(bookLoanRequestDTO.personId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        bookLoan.setBook(book);
        bookLoan.setPerson(person);

        BookLoan savedLoan = bookLoanRepository.save(bookLoan);

        return new BookLoanResponseDTO(savedLoan);
    }

    public String deleteLoan(Long loanId){
        BookLoan bookLoan = getBookLoanById(loanId);

        bookLoanRepository.delete(bookLoan);

        return "Book Loan: " + loanId + " deleted.";
    }

    private BookLoan getBookLoanById(Long loanId){
        return bookLoanRepository.findById(loanId).orElseThrow(() -> new EntityNotFoundException(loanId));
    }

    @Transactional
    public BookLoanResponseDTO createLoan(BookLoanRequestDTO bookLoanRequestDTO){
        Book book = bookRepository.findById(bookLoanRequestDTO.bookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.getIsAvailable()) {
            throw new RuntimeException("Book is currently unavailable");
        }

        Person person = personRepository.findById(bookLoanRequestDTO.personId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        book.setIsAvailable(false);
        bookRepository.save(book);

        BookLoan bookLoan = BookLoan.builder()
                .book(book)
                .person(person)
                .loanDate(LocalDate.now())
                .expectedReturnDate(LocalDate.now().plusDays(7))
                .build();

        BookLoan savedLoan = bookLoanRepository.save(bookLoan);
        return new BookLoanResponseDTO(savedLoan);
    }

    @Transactional
    public BookLoanResponseDTO returnBook(Long loanId) {
        BookLoan bookLoan = getBookLoanById(loanId);

        if (bookLoan.getActualReturnDate() != null) {
            throw new RuntimeException("This loan has already been returned");
        }

        bookLoan.setActualReturnDate(LocalDate.now());

        Book book = bookLoan.getBook();
        book.setIsAvailable(true);
        bookRepository.save(book);

        BookLoan savedLoan = bookLoanRepository.save(bookLoan);
        return new BookLoanResponseDTO(savedLoan);
    }
}
