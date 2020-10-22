package com.theyellowpug.gamesessionhandler.controller;

import com.theyellowpug.gamesessionhandler.entity.SoloGameSession;
import com.theyellowpug.gamesessionhandler.repository.SoloGameSessionRepository;
import com.theyellowpug.gamesessionhandler.service.QuestionServiceCaller;
import com.theyellowpug.gamesessionhandler.service.SoloGameSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class SoloGameSessionController {

    private  final SoloGameSessionService soloGameSessionService;

    public SoloGameSessionController(SoloGameSessionService soloGameSessionService) {
        this.soloGameSessionService = soloGameSessionService;
    }


    @PostMapping("/{gameId}/{tag}/{difficulty}")
    public Long createSoloGameSession(@PathVariable("gameId") Long gameId,@PathVariable("difficulty") Short difficulty,@PathVariable("tag") String tag){
        return soloGameSessionService.createSoloGameSession(gameId, difficulty, tag);
    }

    @GetMapping("/{id}")
    public Optional<SoloGameSession> getSoloGameSessionById(@PathVariable("id") Long id){
        return soloGameSessionService.getSoloGameSessionById(id);
    }

    @PutMapping("/{id}/{answer}")
    public SoloGameSession refreshCurrentSession(@PathVariable("id") Long id,@PathVariable("answer") String answer){
        return soloGameSessionService.setGameSessionData(id, answer);
    }

    @PutMapping("/setActive/{id}/{isActive}")
    public String changesSessionActivity(@PathVariable("id") Long id,@PathVariable("isActive") Boolean isActive){
        soloGameSessionService.setSessionActivity(id, isActive);
        return "Game with id: "+id+" is set to "+isActive;
    }

}
