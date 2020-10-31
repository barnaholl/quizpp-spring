package com.theyellowpug.userhandlerservice.controller;

import com.theyellowpug.userhandlerservice.service.GameHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{username}")
    public List<Long> getGameSessionIdsByUsername(@PathVariable("username") String username){
        return gameHistoryService.getGameSessionIdsByUsername(username);
    }

}
