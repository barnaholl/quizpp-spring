package com.theyellowpug.gamehandlerservice.controller;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/")
    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable("id") Long id){
        return gameRepository.getById(id);
    }

    @PostMapping("/")
    public String createGame(@RequestBody Game game){
        gameRepository.save(game);
        return game.getTitle()+" game is created";
    }

    @DeleteMapping("/{id}")
    public String deleteGameById(@PathVariable("id") Long id){
        gameRepository.deleteById(id);
        return "Game at id: "+id+" is successfully deleted";
    }

}
