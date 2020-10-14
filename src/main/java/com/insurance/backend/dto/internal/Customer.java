package com.insurance.backend.dto.internal;

import com.insurance.backend.dto.external.InsuranceType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    @NonNull private Person        person;
    @NonNull private Address       address;
    @NonNull private InsuranceType insuranceType;

}
