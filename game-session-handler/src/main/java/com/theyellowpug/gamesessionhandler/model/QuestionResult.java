package com.theyellowpug.gamesessionhandler.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Data
@NoArgsConstructor
public class QuestionResult {
    private Long id;

    private String question;

    private String wrongAnswer1;

    private String wrongAnswer2;

    private String wrongAnswer3;

    private String correctAnswer;

    private short difficulty;

    private List<String> tags;
}
