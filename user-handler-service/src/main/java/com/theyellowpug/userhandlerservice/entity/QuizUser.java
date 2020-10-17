package com.theyellowpug.userhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //@Enumerated(EnumType.STRING)
    //UserRole roles;


    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    List<String> roles=new ArrayList<>();

    @OneToOne(mappedBy = "quizUser")
    PersonalData personalData;

}
