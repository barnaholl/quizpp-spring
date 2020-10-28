package com.theyellowpug.userhandlerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCurrency {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private QuizUser quizUser;

    @Column(nullable = false)
    private Long score;
}
