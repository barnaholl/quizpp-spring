package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.entity.GameHistory;
import com.theyellowpug.userhandlerservice.entity.QuizUser;
import com.theyellowpug.userhandlerservice.model.SoloGameSessionModel;
import com.theyellowpug.userhandlerservice.repository.GameHistoryRepository;
import com.theyellowpug.userhandlerservice.repository.QuizUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GameHistoryService {
    private final GameHistoryRepository gameHistoryRepository;
    private final QuizUserRepository quizUserRepository;
    private final RestTemplate restTemplate;

    private final String isGameSessionExistUrl="http://game-session-handler-service/isExistByGameIdAndUsername/";
    private final String getGameSessionByGameIdAndUsername="http://game-session-handler-service/";

    public GameHistoryService(GameHistoryRepository gameHistoryRepository, QuizUserRepository quizUserRepository, RestTemplate restTemplate) {
        this.gameHistoryRepository = gameHistoryRepository;
        this.quizUserRepository = quizUserRepository;
        this.restTemplate = restTemplate;
    }

    public void initGameHistory(QuizUser quizUser) {
        GameHistory gameHistory= GameHistory.builder().quizUser(quizUser).build();
        gameHistoryRepository.save(gameHistory);
    }
    public void addGameSessionIdByUsername(String username, Long id){
        QuizUser quizUser=quizUserRepository.findByUsername(username);
        GameHistory gameHistory=gameHistoryRepository.getByQuizUser(quizUser);
        List<Long> gameSessionIds=gameHistory.getGameSessionIds();
        gameSessionIds.add(id);
        gameHistory.setGameSessionIds(gameSessionIds);
        gameHistoryRepository.save(gameHistory);
    }
    public List<Long> getGameSessionIdsByUsername(String username){
        QuizUser quizUser=quizUserRepository.findByUsername(username);
        GameHistory gameHistory=gameHistoryRepository.getByQuizUser(quizUser);
        List<Long> gameSessionIds=gameHistory.getGameSessionIds();
        return gameSessionIds;
    }

    public Boolean isGameSessionExist(Long gameSessionId,String username){
        Boolean isExist=restTemplate.getForObject(isGameSessionExistUrl+gameSessionId+"/"+username, Boolean.class);
        return isExist;
    }

    public SoloGameSessionModel getSoloGameSessionByGameIdAndUsername(Long gameId, String username) {
        return restTemplate.getForEntity(getGameSessionByGameIdAndUsername+gameId+"/"+username, SoloGameSessionModel.class).getBody();
    }
}
