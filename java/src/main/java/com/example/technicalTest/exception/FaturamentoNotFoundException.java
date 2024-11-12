package com.example.technicalTest.exception;

public class FaturamentoNotFoundException extends RuntimeException {
    public FaturamentoNotFoundException(String message) {
        super(message);
    }
}
