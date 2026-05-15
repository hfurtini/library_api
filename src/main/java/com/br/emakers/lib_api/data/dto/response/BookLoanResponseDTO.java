package com.br.emakers.lib_api.data.dto.response;
import com.br.emakers.lib_api.data.entity.BookLoan;

import java.time.LocalDate;

public record BookLoanResponseDTO(
        Long loanId,
        Long bookId,
        Long personId,
        LocalDate loanDate,
        LocalDate expectedReturnDate,
        LocalDate actualReturnDate
) {
    public BookLoanResponseDTO(BookLoan bookLoan) {
        this(
                bookLoan.getLoanId(),
                bookLoan.getBook().getBookId(),
                bookLoan.getPerson().getPersonId(),
                bookLoan.getLoanDate(),
                bookLoan.getExpectedReturnDate(),
                bookLoan.getActualReturnDate()
        );
    }
}
