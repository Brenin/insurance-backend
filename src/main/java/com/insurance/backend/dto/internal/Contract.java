package com.insurance.backend.dto.internal;

import com.insurance.backend.dto.external.InsuranceType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Contract {

    @NonNull  private Person        person;
    @NonNull  private InsuranceType insuranceType;
    @NonNull  private BigDecimal    insuredAmount;
    @NonNull  private String        insuredAmountCurrency;
    @NonNull  private Date          policyStartDate;
    @NonNull  private Date          policyEndDate;

}
