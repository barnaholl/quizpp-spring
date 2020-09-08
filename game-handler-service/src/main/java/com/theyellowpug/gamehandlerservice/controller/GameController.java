package com.theyellowpug.gamehandlerservice.controller;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("")
    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    @PostMapping("")
    public String createGame(@RequestBody Game game){
        gameRepository.save(game);
        return game.getTitle()+" game is created";
    }

}
