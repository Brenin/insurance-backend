package com.insurance.backend.repository;

import com.insurance.backend.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CustomerRepository extends SimpleJpaRepository<CustomerEntity, Integer> {

    public CustomerRepository(EntityManager entityManager) {
        super(CustomerEntity.class, entityManager);
    }
}
