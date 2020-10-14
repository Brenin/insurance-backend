package com.insurance.backend.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "person_entity")
public class PersonEntity extends BasicEntity {

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "client_identification", nullable = false)
    private UUID clientIdentification;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", nullable = false, foreignKey = @ForeignKey(name = ForeignKeys.FK_PERSON_ADDRESS))
    private AddressEntity address;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_citizenship", nullable = false, foreignKey = @ForeignKey(name = ForeignKeys.FK_PERSON_CITIZENSHIP))
    private CitizenshipEntity citizenship;

}
