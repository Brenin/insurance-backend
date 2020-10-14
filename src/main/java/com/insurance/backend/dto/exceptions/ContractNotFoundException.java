package com.insurance.backend.dto.exceptions;

public class ContractNotFoundException extends RuntimeException {

    public ContractNotFoundException(String message) {
        super(message);
    }
}
