package com.br.emakers.lib_api.controller;

import com.br.emakers.lib_api.data.dto.request.BookRequestDTO;
import com.br.emakers.lib_api.data.dto.response.BookResponseDTO;
import com.br.emakers.lib_api.data.entity.Book;
import com.br.emakers.lib_api.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity <List<BookResponseDTO>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity <BookResponseDTO> getBookById(@PathVariable Long bookId){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(bookId));
    }

    @PostMapping("/create")
    public ResponseEntity <BookResponseDTO> resgisterBook(@Valid @RequestBody BookRequestDTO bookRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.registerBook(bookRequestDTO));
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity <BookResponseDTO> updateBook(@PathVariable Long bookId, @Valid @RequestBody BookRequestDTO bookRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(bookId, bookRequestDTO));
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity <String> deleteBook(@PathVariable Long bookId){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBook(bookId));
    }

}
