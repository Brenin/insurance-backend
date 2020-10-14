package com.insurance.backend.config;

import com.insurance.backend.dto.external.AddressDTO;
import com.insurance.backend.dto.internal.Person;
import com.insurance.backend.repository.entity.AddressEntity;
import com.insurance.backend.repository.entity.CitizenshipEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

        return modelMapper;
    }
}
