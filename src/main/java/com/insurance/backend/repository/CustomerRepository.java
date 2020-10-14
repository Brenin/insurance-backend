package com.insurance.backend.repository;

import com.insurance.backend.repository.entity.ContractEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CustomerRepository extends SimpleJpaRepository<ContractEntity, Integer> {

    public CustomerRepository(EntityManager entityManager) {
        super(ContractEntity.class, entityManager);
    }
}
