package com.insurance.backend.service;

import com.insurance.backend.dto.operations.CancelContractRequest;
import javafx.util.Pair;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkflowCancellationService {

    @Transactional
    public Pair<Boolean, Boolean> rollBackCustomerAndContractCreationIfApplicable(@NonNull CancelContractRequest request) {
        // This method will roll back the customer creation and the contract creation

        // 1. Remove the contract
        // 2. Check if customer should be removed by searching for existing active contracts for customer
        // 3. If none are found, delete customer

        return new Pair<>(false, false);
    }
}
