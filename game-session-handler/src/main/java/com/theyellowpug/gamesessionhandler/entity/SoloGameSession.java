package com.theyellowpug.gamesessionhandler.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SoloGameSession {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    Long gameId;

    @Column(nullable = false)
    Short difficulty;

    @Column(nullable = false)
    String tag;

    @ElementCollection
    List<Long> answeredQuestions;

    Long currentQuestion;

    @Column(nullable = false)
    Boolean isActive;

    @Column(nullable = false)
    Short currentRound;

    //TODO:User


}
