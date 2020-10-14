package com.insurance.backend.repository;

import com.insurance.backend.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PersonRepository extends SimpleJpaRepository<PersonEntity, Integer> {

    public PersonRepository(EntityManager entityManager) {
        super(PersonEntity.class, entityManager);
    }
}
