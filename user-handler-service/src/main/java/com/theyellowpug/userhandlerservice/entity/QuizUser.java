package com.theyellowpug.userhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class QuizUser {
    @Id
    @GeneratedValue
    Long id;

    String username;

    String password;

    @Enumerated(EnumType.STRING)
    UserRole userRole;

    @OneToOne(mappedBy = "quizUser")
    PersonalData personalData;

}
