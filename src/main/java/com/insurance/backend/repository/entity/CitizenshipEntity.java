package com.insurance.backend.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person_citizenship")
public class CitizenshipEntity extends BasicEntity {

    @JoinColumn(name = "id_person", foreignKey = @ForeignKey(name = ForeignKeys.FK_CITIZENSHIP_PERSON))
    private PersonEntity person;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

}
