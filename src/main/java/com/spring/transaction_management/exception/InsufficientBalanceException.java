package com.spring.transaction_management.exception;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String errMsg) {
        super(errMsg);
    }
}
