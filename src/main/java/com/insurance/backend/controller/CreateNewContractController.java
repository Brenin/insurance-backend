package com.insurance.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.backend.dto.operations.NewContractRequest;
import com.insurance.backend.dto.operations.NewContractResponse;
import com.insurance.backend.service.CreateNewContractService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateNewContractController {

    private final CreateNewContractService createNewContractService;

    @Autowired
    public CreateNewContractController(CreateNewContractService createNewContractService) {
        this.createNewContractService = createNewContractService;
    }

    @PostMapping("/contract/create")
    public String createNewContract(@NonNull @RequestBody NewContractRequest request) throws JsonProcessingException {
        String contractNumber = null;
        String errorMessage   = null;
        try {
            // We should verify the internal fields of the incoming request object according to business requirements
            // At the moment we only have the requirement of them being NonNull
            contractNumber = createNewContractService.createNewContract(request);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        // Objects were read with null values back in the gateway so I'll do it the basic way instead
        return new ObjectMapper().writer().writeValueAsString(new NewContractResponse(errorMessage, contractNumber));
    }

}
