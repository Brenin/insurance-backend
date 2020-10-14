package com.insurance.backend.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person_address")
public class AddressEntity extends BasicEntity {

    @JoinColumn(name = "id_person", nullable = false, foreignKey = @ForeignKey(name = ForeignKeys.FK_ADDRESS_PERSON))
    private PersonEntity person;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "entrance")
    private String entrance;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "floor")
    private String floor;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "city", nullable = false)
    private String city;

}
