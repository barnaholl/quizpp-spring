package com.theyellowpug.userhandlerservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

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

    @Column(unique = true)
    String username;

    String password;

    //@Enumerated(EnumType.STRING)
    //UserRole roles;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    List<String> roles=new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @OneToOne(mappedBy = "quizUser")
    PersonalData personalData;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @OneToOne(mappedBy = "quizUser")
    UserCurrency userCurrency;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    @OneToOne(mappedBy = "quizUser")
    GameHistory gameHistory;


}
