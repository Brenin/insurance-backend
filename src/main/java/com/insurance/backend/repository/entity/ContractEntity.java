package com.insurance.backend.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "contract_entity")
public class ContractEntity extends BasicEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", updatable = false, nullable = false, foreignKey = @ForeignKey(name = ForeignKeys.FK_CONTRACT_PERSON))
    private PersonEntity person;

    @Column(name = "contract_identification", nullable = false)
    private UUID contractIdentification;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "insurance_type", nullable = false)
    private String insuranceType;

    @Column(name = "insured_amount", nullable = false)
    private BigDecimal insuredAmount;

    @Column(name = "insured_amount_currency", nullable = false)
    private String insuredAmountCurrency;

    @Column(name = "policy_start_date", nullable = false)
    private Date policyStartDate;

    @Column(name = "policy_end_date", nullable = false)
    private Date policyEndDate;

}
