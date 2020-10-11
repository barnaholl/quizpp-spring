package com.theyellowpug.userhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrlPerson {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String emailAddress;

    @Column(nullable = false)
    Date birthDate;

    @Column(nullable = false)
    String country;

    @Column(nullable = false)
    String sex;


}
