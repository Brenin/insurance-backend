package com.insurance.backend.dto.operations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewCustomerResponse extends AbstractResponse {

    private String customerIdentification;

    public NewCustomerResponse(String errorMessage, String customerIdentification) {
        super(errorMessage);
        this.customerIdentification = customerIdentification;
    }
}
