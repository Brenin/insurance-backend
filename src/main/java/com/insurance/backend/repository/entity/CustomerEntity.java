package com.insurance.backend.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customer_entity")
public class CustomerEntity extends BasicEntity {

    @Column(name = "customer_identifier", nullable = false)
    private UUID customerIdentifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", nullable = false, foreignKey = @ForeignKey(name = ForeignKeys.FK_CUSTOMER_PERSON))
    private PersonEntity person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_insurance", nullable = false, foreignKey = @ForeignKey(name = ForeignKeys.FK_CUSTOMER_INSURANCE_TYPE))
    private InsuranceTypeEntity insuranceType;

}
