package com.br.emakers.lib_api.controller;

import com.br.emakers.lib_api.data.dto.request.BookLoanRequestDTO;
import com.br.emakers.lib_api.data.dto.response.BookLoanResponseDTO;
import com.br.emakers.lib_api.service.BookLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookloan")
public class BookLoanController {

    @Autowired
    private BookLoanService bookLoanService;

    @GetMapping("/all")
    public ResponseEntity <List<BookLoanResponseDTO>> getAllLoans() {
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.getAllLoans());
    }

    @GetMapping("/{loanId}")
    public ResponseEntity <BookLoanResponseDTO> getLoanById(@PathVariable Long loanId){
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.getLoanById(loanId));
    }

    @PostMapping("/create")
    public ResponseEntity <BookLoanResponseDTO> createLoan(@RequestBody BookLoanRequestDTO bookLoanRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookLoanService.createLoan(bookLoanRequestDTO));
    }

    @PutMapping("/update/{loanId}")
    public ResponseEntity <BookLoanResponseDTO> updateLoan(@PathVariable Long loanId, @RequestBody BookLoanRequestDTO bookLoanRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.updateLoan(loanId, bookLoanRequestDTO));
    }

    @DeleteMapping("/delete/{loanId}")
    public ResponseEntity <String> deleteLoan(@PathVariable Long loanId){
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.deleteLoan(loanId));
    }

}
