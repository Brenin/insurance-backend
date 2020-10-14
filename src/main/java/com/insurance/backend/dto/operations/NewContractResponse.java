package com.insurance.backend.dto.operations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewContractResponse extends AbstractResponse {

    private String contractIdentification;

    public NewContractResponse(String errorMessage, String contractIdentification) {
        super(errorMessage);
        this.contractIdentification = contractIdentification;
    }
}
