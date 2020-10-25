package com.theyellowpug.userhandlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationData {
    private Long id;

    private String username;
    private String password;

    private List<String> roles;

    private String emailAddress;
    private Date birthDate;
    private String sex;
    private String country;
}
