package com.theyellowpug.userhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonalData {
    @Id
    @GeneratedValue
    Long id;

    String emailAddress;

    Date birthDate;

    String sex;

    String country;

    @OneToOne(cascade = CascadeType.ALL)
    QuizUser quizUser;

}
