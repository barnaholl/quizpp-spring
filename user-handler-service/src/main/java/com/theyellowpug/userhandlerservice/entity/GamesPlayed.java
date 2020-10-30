package com.theyellowpug.userhandlerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GamesPlayed {

    @Id
    @GeneratedValue
    Long id;

    @JsonIgnore
    @OneToOne
    QuizUser quizUser;

    Long gameId;
}
