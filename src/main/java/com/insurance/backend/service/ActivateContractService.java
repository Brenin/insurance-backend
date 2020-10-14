package com.insurance.backend.service;

import com.insurance.backend.repository.ContractRepository;
import com.insurance.backend.repository.entity.ContractEntity;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivateContractService {

    private final ContractRepository contractRepository;

    @Autowired
    public ActivateContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Transactional
    public boolean activateContract(@NonNull String contractIdentification) {

        ContractEntity contract = contractRepository.findContractByIdentification(contractIdentification); // Exception if not found

        contract.setActive(true);

        contractRepository.save(contract);

        return true;
    }

}
