package com.insurance.backend.repository;

import com.insurance.backend.repository.entity.AddressEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AddressRepository extends SimpleJpaRepository<AddressEntity, Integer> {

    public AddressRepository(EntityManager entityManager) {
        super(AddressEntity.class, entityManager);
    }
}
