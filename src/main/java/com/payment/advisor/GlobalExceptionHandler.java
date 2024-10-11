package com.payment.advisor;

import java.net.URI;
import java.net.URISyntaxException;

import com.payment.exception.InsufficientFundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientFundsException.class)
    public ProblemDetail handleInsufficientFunds(InsufficientFundsException ex) throws URISyntaxException {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, ex.getMessage());
        problemDetail.setTitle("Insufficient Funds");
        problemDetail.setType(new URI("https://example.com/probs/insufficient-funds"));
        problemDetail.setInstance(new URI("/transactions/12345"));
        return problemDetail;
    }
}
