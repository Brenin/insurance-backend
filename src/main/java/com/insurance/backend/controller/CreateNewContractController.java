package com.insurance.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateNewContractController {

    @PostMapping("/contract/create")
    public String createNewContract() {


        return null;
    }

}
