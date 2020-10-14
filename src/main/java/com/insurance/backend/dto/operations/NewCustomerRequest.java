package com.insurance.backend.dto.operations;

import com.insurance.backend.dto.external.AddressDTO;
import com.insurance.backend.dto.external.PersonDataDTO;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class NewCustomerRequest {

    @NonNull private PersonDataDTO personData;
    @NonNull private AddressDTO    address;

}
