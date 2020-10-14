package com.insurance.backend.repository;

import com.insurance.backend.repository.entity.InsuranceTypeEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class InsuranceTypeRepository extends SimpleJpaRepository<InsuranceTypeEntity, Integer> {

    public InsuranceTypeRepository(EntityManager entityManager) {
        super(InsuranceTypeEntity.class, entityManager);
    }
}
