package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.GameHistory;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.repository.GameHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameHistoryService {
    private final GameHistoryRepository gameHistoryRepository;

    public GameHistoryService(GameHistoryRepository gameHistoryRepository) {
        this.gameHistoryRepository = gameHistoryRepository;
    }

    public void initGameHistory(QuizUser quizUser) {
        GameHistory gameHistory= GameHistory.builder().quizUser(quizUser).build();
        gameHistoryRepository.save(gameHistory);
    }
    public void addGameSessionId(QuizUser quizUser, Long id){
        GameHistory gameHistory=gameHistoryRepository.getByQuizUser(quizUser);
        List<Long> gameSessionIds=gameHistory.getGameSessionIds();
        gameSessionIds.add(id);
        gameHistory.setGameSessionIds(gameSessionIds);
        gameHistoryRepository.save(gameHistory);
    }
}
