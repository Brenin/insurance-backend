package com.insurance.backend.dto.operations;

import com.insurance.backend.dto.external.InsuranceType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewContractRequest {

    private String        customerIdentification;
    private InsuranceType insuranceType;
    private BigDecimal    insuredAmount;
    private String        insuredAmountCurrency; // 3 letter currency code, ex NOK, RON, EUR
    private String        startDate;
    private String        endDate;

}
