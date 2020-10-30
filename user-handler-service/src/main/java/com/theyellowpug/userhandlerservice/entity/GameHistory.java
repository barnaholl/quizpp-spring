package com.theyellowpug.userhandlerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class GameHistory {

    @Id
    @GeneratedValue
    Long id;

    @JsonIgnore
    @OneToOne
    QuizUser quizUser;

    //Long gameId;

    @ElementCollection
    List<Long> gameSessionIds;
}
