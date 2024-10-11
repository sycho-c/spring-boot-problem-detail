package com.payment.controller;

import com.payment.exception.InsufficientFundsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping("/make-payment")
    public String makePayment(@RequestParam int amount) {
        int balance = 30;  // User's current balance
        if (amount > balance) {
            throw new InsufficientFundsException("Your current balance is " + balance + ", but the transaction requires " + amount);
        }
        return "Payment successful!";
    }
}
