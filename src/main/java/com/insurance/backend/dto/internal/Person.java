package com.insurance.backend.dto.internal;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Person {

    @NonNull private String lastName;
    @NonNull private String firstName;
    @NonNull private String email;
    @NonNull private String pin;
    @NonNull private String citizenshipCountryCode; // 3 letter country code

}
