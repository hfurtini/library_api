package com.br.emakers.lib_api.service;

import com.br.emakers.lib_api.data.dto.request.BookRequestDTO;
import com.br.emakers.lib_api.data.dto.response.BookResponseDTO;
import com.br.emakers.lib_api.data.entity.Book;
import com.br.emakers.lib_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookResponseDTO> getAllBooks(){
        List<Book> books = bookRepository.findAll();

        return books.stream().map(BookResponseDTO::new).collect(Collectors.toList());
    }

    public BookResponseDTO getBookById(Long bookId){
        Book book = getBookEntityById(bookId);

        return new BookResponseDTO(book);
    }

    public BookResponseDTO registerBook(BookRequestDTO bookRequestDTO){
        Book book = new Book(bookRequestDTO);
        bookRepository.save(book);

        return new BookResponseDTO(book);
    }

    public BookResponseDTO updateBook(Long bookId, BookRequestDTO bookRequestDTO){
        Book book = getBookEntityById(bookId);

        book.setName(bookRequestDTO.name());
        bookRepository.save(book);

        book.setAuthor(bookRequestDTO.author());
        bookRepository.save(book);

        book.setReleaseDate(bookRequestDTO.releaseDate());
        bookRepository.save(book);

        return new BookResponseDTO(book);
    }

    public String deleteBook(Long bookId){
        Book book = getBookEntityById(bookId);

        bookRepository.delete(book);

        return "Book name: " + book.getName() + " deleted.";
    }

    private Book getBookEntityById(Long bookId){
       return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
    }

}
