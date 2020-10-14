package com.insurance.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.backend.dto.operations.NewCustomerRequest;
import com.insurance.backend.dto.operations.NewCustomerResponse;
import com.insurance.backend.service.CreateNewCustomerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateNewCustomerController {

    private final CreateNewCustomerService createNewCustomerService;

    @Autowired
    public CreateNewCustomerController(CreateNewCustomerService createNewCustomerService) {
        this.createNewCustomerService = createNewCustomerService;
    }

    @PostMapping("/customer/create")
    public String createNewCustomer(@NonNull @RequestBody NewCustomerRequest request) throws JsonProcessingException {
        String customerNumber = null;
        String errorMessage   = null;
        try {
            // We should verify the internal fields of the incoming request object according to business requirements
            // At the moment we only have the requirement of them being NonNull
            customerNumber = createNewCustomerService.createNewCustomer(request);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }

        return new ObjectMapper().writer().writeValueAsString(new NewCustomerResponse(customerNumber, errorMessage));
    }
}
