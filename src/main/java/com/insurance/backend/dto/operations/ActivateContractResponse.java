package com.insurance.backend.dto.operations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivateContractResponse extends AbstractResponse {

    private boolean contractWasActivated;

    public ActivateContractResponse(String errorMessage, boolean contractWasActivated) {
        super(errorMessage);
        this.contractWasActivated = contractWasActivated;
    }
}
