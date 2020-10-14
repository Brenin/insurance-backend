package com.insurance.backend.config;

import com.insurance.backend.dto.external.AddressDTO;
import com.insurance.backend.dto.internal.Person;
import com.insurance.backend.dto.operations.NewContractRequest;
import com.insurance.backend.repository.entity.AddressEntity;
import com.insurance.backend.repository.entity.CitizenshipEntity;
import com.insurance.backend.repository.entity.ContractEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(Person.class, CitizenshipEntity.class)
                .addMapping(Person::getCitizenshipCountryCode, CitizenshipEntity::setCountryCode)
                .addMapping(Person::getPin, CitizenshipEntity::setPin);

        modelMapper.createTypeMap(AddressDTO.class, AddressEntity.class)
                .addMapping(AddressDTO::getCountryThreeLetterCode, AddressEntity::setCountryCode);

        Converter<String, Date> dateConverter = input -> {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(input.getSource());
            } catch (ParseException e) {
                return null;
            }
        };

        modelMapper.createTypeMap(NewContractRequest.class, ContractEntity.class)
                .addMappings(mapper -> mapper.map(src -> false, ContractEntity::setActive))
                .addMappings(mapper -> mapper.using(dateConverter).map(NewContractRequest::getStartDate, ContractEntity::setPolicyStartDate))
                .addMappings(mapper -> mapper.using(dateConverter).map(NewContractRequest::getEndDate, ContractEntity::setPolicyEndDate));

        return modelMapper;
    }
}
