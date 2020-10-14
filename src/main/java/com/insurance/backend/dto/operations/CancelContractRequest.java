package com.insurance.backend.dto.operations;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CancelContractRequest {

    @NonNull private String customerIdentification;
    @NonNull private String contractIdentification;

}
