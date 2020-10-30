package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.GameHistory;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameHistoryRepository extends JpaRepository<GameHistory,Long> {
    GameHistory getByQuizUser(QuizUser quizUser);
}
