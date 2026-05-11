package com.br.emakers.lib_api.controller;

import com.br.emakers.lib_api.data.dto.request.BookLoanRequestDTO;
import com.br.emakers.lib_api.data.dto.response.BookLoanResponseDTO;
import com.br.emakers.lib_api.service.BookLoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book Loan", description = "Endpoints for book loan management")
@RestController
@RequiredArgsConstructor
@RequestMapping("/bookloan")
public class BookLoanController {

    @Autowired
    private BookLoanService bookLoanService;

    @Operation(summary = "Get all loans", description = "Returns a list of all registered loans",
            tags = {"Book Loan"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookLoanResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<BookLoanResponseDTO>> getAllLoans() {
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.getAllLoans());
    }

    @Operation(summary = "Get loan by ID", description = "Returns a single loan by its ID",
            tags = {"Book Loan"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookLoanResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @GetMapping(value = "/{loanId}", produces = "application/json")
    public ResponseEntity<BookLoanResponseDTO> getLoanById(@PathVariable Long loanId){
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.getLoanById(loanId));
    }

    @Operation(summary = "Create a new loan", description = "Creates a new book loan for a person",
            tags = {"Book Loan"},
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201",
                            content = @Content(schema = @Schema(implementation = BookLoanResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookLoanResponseDTO> createLoan(@Valid @RequestBody BookLoanRequestDTO bookLoanRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookLoanService.createLoan(bookLoanRequestDTO));
    }

    @Operation(summary = "Update a loan", description = "Updates the data of an existing loan by its ID",
            tags = {"Book Loan"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookLoanResponseDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @PutMapping(value = "/update/{loanId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BookLoanResponseDTO> updateLoan(@PathVariable Long loanId, @Valid @RequestBody BookLoanRequestDTO bookLoanRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.updateLoan(loanId, bookLoanRequestDTO));
    }

    @Operation(summary = "Delete a loan", description = "Deletes a loan from the database by its ID",
            tags = {"Book Loan"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    @DeleteMapping(value = "/delete/{loanId}", produces = "application/json")
    public ResponseEntity<String> deleteLoan(@PathVariable Long loanId){
        return ResponseEntity.status(HttpStatus.OK).body(bookLoanService.deleteLoan(loanId));
    }
}