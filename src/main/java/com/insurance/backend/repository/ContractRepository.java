package com.insurance.backend.repository;

import com.insurance.backend.dto.exceptions.ContractNotFoundException;
import com.insurance.backend.repository.entity.ContractEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class ContractRepository extends SimpleJpaRepository<ContractEntity, Integer> {

    public ContractRepository(EntityManager entityManager) {
        super(ContractEntity.class, entityManager);
    }

    public ContractEntity findContractByIdentification(String contractIdentification) {
        return findOne((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("contractIdentification"), UUID.fromString(contractIdentification)))
                .orElseThrow(() -> new ContractNotFoundException("Could not find a contract with identification number : " + contractIdentification));
    }
}
