package com.insurance.backend.repository;

import com.insurance.backend.repository.entity.CitizenshipEntity;
import com.insurance.backend.repository.entity.CitizenshipEntity_;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CitizenshipRepository extends SimpleJpaRepository<CitizenshipEntity, Integer> {

    public CitizenshipRepository(EntityManager entityManager) {
        super(CitizenshipEntity.class, entityManager);
    }

    // The combination pin and country should in theory be unique
    public CitizenshipEntity checkIfCustomerAlreadyExistsByPinAndCountry(String pin, String countryCode) {
        return findOne((root, query, criteriaBuilder) -> criteriaBuilder.and(
                criteriaBuilder.equal(root.get(CitizenshipEntity_.pin), pin),
                criteriaBuilder.equal(root.get(CitizenshipEntity_.countryCode), countryCode)
        )).orElse(null);
    }
}
