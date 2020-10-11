package com.theyellowpug.userhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalData {
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

    @OneToOne(mappedBy = "irlPerson")
    QuizUser quizUser;


}
