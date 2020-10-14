package com.insurance.backend.dto.operations;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class ActivateContractRequest {

    @NonNull private String contractIdentification;

}
