package com.insurance.backend.repository;

import com.insurance.backend.dto.exceptions.CustomerNotFoundException;
import com.insurance.backend.repository.entity.CitizenshipEntity;
import com.insurance.backend.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PersonRepository extends SimpleJpaRepository<PersonEntity, Integer> {

    public PersonRepository(EntityManager entityManager) {
        super(PersonEntity.class, entityManager);
    }

    public PersonEntity findByCustomerIdentificationNumber(String clientIdentification) {
        return findOne((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("clientIdentification"), UUID.fromString(clientIdentification)))
                .orElseThrow(() -> new CustomerNotFoundException("Could not find a customer with the identification of : " + clientIdentification));
    }

    public Optional<PersonEntity> findByCitizenship(CitizenshipEntity citizenshipEntity) {
        return findOne((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("citizenship"), citizenshipEntity));
    }
}
