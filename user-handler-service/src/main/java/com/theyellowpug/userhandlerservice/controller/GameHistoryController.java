package com.theyellowpug.userhandlerservice.controller;

import com.theyellowpug.userhandlerservice.model.SoloGameSessionModel;
import com.theyellowpug.userhandlerservice.service.GameHistoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game-history")
public class GameHistoryController {
    private final GameHistoryService gameHistoryService;

    public GameHistoryController(GameHistoryService gameHistoryService) {
        this.gameHistoryService = gameHistoryService;
    }
    @PostMapping("/{username}/{gameSessionId}")
    public String addGameSessionByUsername(@PathVariable("username") String username,@PathVariable("gameSessionId") Long gameSessionId){
        gameHistoryService.addGameSessionIdByUsername(username,gameSessionId);
        return "gameSessionId: "+gameSessionId+" added to the GameHistory of user: "+username;
    }

    @GetMapping("/isGameSessionExistByGameIdAndUsername/{gameId}/{username}")
    public Boolean isGameSessionExistByUsername(@PathVariable("gameId") Long gameId, @PathVariable("username") String username){
        return gameHistoryService.isGameSessionExist(gameId, username);
    }

    @GetMapping("/getSoloGameSessionByGameIdAndUsername/{gameId}/{username}")
    public SoloGameSessionModel getSoloGameSessionByGameIdAndUsername(@PathVariable("gameId") Long gameId, @PathVariable("username") String username){
        return gameHistoryService.getSoloGameSessionByGameIdAndUsername(gameId,username);
    }

}
