package com.theyellowpug.gamesessionhandler.controller;

import com.theyellowpug.gamesessionhandler.entity.SoloGameSession;
import com.theyellowpug.gamesessionhandler.repository.SoloGameSessionRepository;
import com.theyellowpug.gamesessionhandler.service.QuestionServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("")
public class SoloGameSessionController {

    @Autowired
    private SoloGameSessionRepository soloGameSessionRepository;
    @Autowired
    QuestionServiceCaller questionServiceCaller;

    @PostMapping("/{gameId}/{tag}/{difficulty}")
    public Long createSoloGameSession(@PathVariable("gameId") Long gameId,@PathVariable("difficulty") Short difficulty,@PathVariable("tag") String tag){
        SoloGameSession gameSession = SoloGameSession.builder()
                .gameId(gameId)
                .difficulty(difficulty)
                .tag(tag)
                .isActive(true)
                .currentRound((short) 1)
                .currentQuestion(questionServiceCaller.getQuestionId(tag, difficulty))
                .build();
        soloGameSessionRepository.save(gameSession);
        return gameSession.getId();

    }

    @GetMapping("/{id}")
    public Optional<SoloGameSession> getSoloGameSessionById(@PathVariable("id") Long id){
        return soloGameSessionRepository.findById(id);
    }

    @PutMapping("/{id}/{isCorrect}")
    public SoloGameSession refreshCurrentSession(@PathVariable("id") Long id,@PathVariable("isCorrect") Boolean isCorrect){
        SoloGameSession gameSession=soloGameSessionRepository.getById(id);

        gameSession.setIsActive(isCorrect);
        if(isCorrect){
            List<Long> answeredQuestions=gameSession.getAnsweredQuestions();
            answeredQuestions.add(gameSession.getCurrentQuestion());

            Long newQuestion=questionServiceCaller.getQuestionId(gameSession.getTag(), gameSession.getDifficulty());
            while (gameSession.getAnsweredQuestions().contains(newQuestion)){
                newQuestion=questionServiceCaller.getQuestionId(gameSession.getTag(), gameSession.getDifficulty());
            }
            gameSession.setCurrentQuestion(newQuestion);

            gameSession.setCurrentRound((short) (gameSession.getCurrentRound()+1));
        }

        soloGameSessionRepository.save(gameSession);

        return gameSession;
    }

}
