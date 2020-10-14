package com.insurance.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.backend.dto.operations.CancelContractRequest;
import com.insurance.backend.dto.operations.CancelContractResponse;
import com.insurance.backend.service.WorkflowCancellationService;
import javafx.util.Pair;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkflowCancellationController {

    private final WorkflowCancellationService workflowCancellationService;

    @Autowired
    public WorkflowCancellationController(WorkflowCancellationService workflowCancellationService) {
        this.workflowCancellationService = workflowCancellationService;
    }

    @PostMapping("/contract/cancel")
    public String cancelContractAndCustomer(@NonNull @RequestBody CancelContractRequest request) throws JsonProcessingException {
        Pair<Boolean, Boolean> rollbackFlags = new Pair<>(false, false);
        String errorMessage   = null;
        try {
            // We should verify the internal fields of the incoming request object according to business requirements
            // At the moment we only have the requirement of them being NonNull
            rollbackFlags = workflowCancellationService.rollBackCustomerAndContractCreationIfApplicable(request);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        // Objects were read with null values back in the gateway so I'll do it the basic way instead
        return new ObjectMapper().writer().writeValueAsString(new CancelContractResponse(errorMessage, rollbackFlags));
    }

}
