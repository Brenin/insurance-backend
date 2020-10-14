package com.insurance.backend.dto.operations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomerResponse {

    private String customerIdentification;
    private String errorMessage;
}
