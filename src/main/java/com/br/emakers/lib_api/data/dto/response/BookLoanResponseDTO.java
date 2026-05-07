package com.br.emakers.lib_api.data.dto.response;
import com.br.emakers.lib_api.data.entity.BookLoan;
import com.br.emakers.lib_api.data.entity.Person;
import com.br.emakers.lib_api.data.entity.Book;

public record BookLoanResponseDTO(
        Long loanId,
        String bookName,
        String personName

) {
    public BookLoanResponseDTO(BookLoan loan){
        this(
                loan.getLoanId(),
                loan.getBook().getName(),
                loan.getPerson().getName()
        );
    }
}
