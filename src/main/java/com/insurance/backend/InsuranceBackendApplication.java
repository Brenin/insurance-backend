package com.insurance.backend;

import com.insurance.backend.util.LoggingUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsuranceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceBackendApplication.class, args);

        LoggingUtil.logInfo("--------------------------------------------------");
        LoggingUtil.logInfo(InsuranceBackendApplication.class.getSimpleName() + " started successfully in embedded tomcat");
        LoggingUtil.logInfo("--------------------------------------------------");
    }

}
