package com.theyellowpug.gamesessionhandler.service;

import com.theyellowpug.gamesessionhandler.entity.SoloGameSession;
import com.theyellowpug.gamesessionhandler.repository.SoloGameSessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SoloGameSessionService {

    private final SoloGameSessionRepository soloGameSessionRepository;

    private final QuestionServiceCaller questionServiceCaller;

    public SoloGameSessionService(SoloGameSessionRepository soloGameSessionRepository, QuestionServiceCaller questionServiceCaller) {
        this.soloGameSessionRepository = soloGameSessionRepository;
        this.questionServiceCaller = questionServiceCaller;
    }

    public Long createSoloGameSession(Long gameId,String username, Short difficulty, String tag){
        LocalDateTime roundEnd=LocalDateTime.now().plusSeconds(30);

        SoloGameSession gameSession = SoloGameSession.builder()
                .gameId(gameId)
                .username(username)
                .difficulty(difficulty)
                .tag(tag)
                .isActive(true)
                .isGameWon(false)
                .currentRound((short) 1)
                .currentQuestion(questionServiceCaller.getQuestionId(tag, difficulty))
                .roundEnd(roundEnd)
                .build();
        soloGameSessionRepository.save(gameSession);
        return gameSession.getId();
    }

    public Optional<SoloGameSession> getSoloGameSessionById(Long id){
        return soloGameSessionRepository.findById(id);
    }

    public SoloGameSession setGameSessionData(Long id, String answer){
        SoloGameSession gameSession=soloGameSessionRepository.getById(id);
        if(questionServiceCaller.isAnswerCorrect(gameSession.getCurrentQuestion(),answer)){
            gameSession.setIsActive(true);

            List<Long> answeredQuestions=gameSession.getAnsweredQuestions();
            answeredQuestions.add(gameSession.getCurrentQuestion());

            Long newQuestion=questionServiceCaller.getQuestionId(gameSession.getTag(), gameSession.getDifficulty());
            while (gameSession.getAnsweredQuestions().contains(newQuestion)){
                newQuestion=questionServiceCaller.getQuestionId(gameSession.getTag(), gameSession.getDifficulty());
            }
            gameSession.setCurrentQuestion(newQuestion);

            gameSession.setCurrentRound((short) (gameSession.getCurrentRound()+1));

            gameSession.setRoundEnd(LocalDateTime.now().plusSeconds(30));
        }
        else{
            gameSession.setIsActive(false);
        }

        soloGameSessionRepository.save(gameSession);

        return gameSession;
    }

    public void setSessionActivity(Long id, Boolean isActive, Boolean isGameWon){
        SoloGameSession gameSession=soloGameSessionRepository.getById(id);
        gameSession.setIsActive(isActive);
        gameSession.setIsGameWon(isGameWon);
        soloGameSessionRepository.save(gameSession);
    }

    public Boolean isSoloGameSessionExist(Long gameId,String username){
        return soloGameSessionRepository.existsByGameIdAndUsername(gameId,username);
    }

    public SoloGameSession getSoloGameSessionByGameIdAndUsername(Long gameId, String username) {
        return soloGameSessionRepository.findByGameIdAndUsername(gameId, username);
    }
}
