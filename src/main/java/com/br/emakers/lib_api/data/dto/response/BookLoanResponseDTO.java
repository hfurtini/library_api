package com.br.emakers.lib_api.data.dto.response;
import com.br.emakers.lib_api.data.entity.BookLoan;

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
