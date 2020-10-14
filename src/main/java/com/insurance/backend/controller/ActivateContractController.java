package com.insurance.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.backend.dto.operations.ActivateContractRequest;
import com.insurance.backend.dto.operations.ActivateContractResponse;
import com.insurance.backend.service.ActivateContractService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivateContractController {

    private final ActivateContractService activateContractService;

    @Autowired
    public ActivateContractController(ActivateContractService activateContractService) {
        this.activateContractService = activateContractService;
    }

    @PostMapping("/contract/activate")
    public String activateContract(@NonNull @RequestBody ActivateContractRequest request) throws JsonProcessingException {
        boolean contractWasActivated = false;
        String errorMessage          = null;
        try {
            // We should verify the internal fields of the incoming request object according to business requirements
            // At the moment we only have the requirement of them being NonNull
            contractWasActivated = activateContractService.activateContract(request.getContractIdentification());
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        // Objects were read with null values back in the gateway so I'll do it the basic way instead
        return new ObjectMapper().writer().writeValueAsString(new ActivateContractResponse(errorMessage, contractWasActivated));
    }

}
