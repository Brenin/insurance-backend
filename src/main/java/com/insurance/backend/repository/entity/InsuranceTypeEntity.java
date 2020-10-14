package com.insurance.backend.repository.entity;

import com.insurance.backend.dto.external.InsuranceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "insurance_type")
public class InsuranceTypeEntity extends BasicEntity {

    @Column(name = "insurance_type", nullable = false)
    private InsuranceType insuranceType;

}
