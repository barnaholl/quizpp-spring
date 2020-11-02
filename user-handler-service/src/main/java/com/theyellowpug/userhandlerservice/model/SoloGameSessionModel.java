package com.theyellowpug.userhandlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SoloGameSessionModel {

    Long id;

    Long gameId;

    String username;

    Short difficulty;

    String tag;

    List<Long> answeredQuestions;

    Long currentQuestion;

    Boolean isActive;

    Boolean isGameWon;

    Short currentRound;

    LocalDateTime roundEnd;
}
