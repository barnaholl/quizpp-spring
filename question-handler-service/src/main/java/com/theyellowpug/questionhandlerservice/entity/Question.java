package com.theyellowpug.questionhandlerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String wrongAnswer1;

    @Column(nullable = false)
    private String wrongAnswer2;

    @Column(nullable = false)
    private String wrongAnswer3;

    @Column(nullable = false)
    private String correctAnswer;

    @Column(nullable = false)
    private short difficulty;

    @ElementCollection
    private List<String> tags;


}
