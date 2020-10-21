package com.theyellowpug.gamehandlerservice.controller;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import com.theyellowpug.gamehandlerservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class GameController {

    //TODO:DELETE
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable("id") Long id){
        return gameService.getGameById(id);
    }

    @PostMapping("/")
    public String createGame(@RequestBody Game game){
        return gameService.createGame(game);
    }

    @DeleteMapping("/{id}")
    public String deleteGameById(@PathVariable("id") Long id){
        return gameService.deleteGameById(id);
    }

    @PutMapping("/{id}/{username}")
    public String addPlayerToPlayersEnrolled(@PathVariable("id") Long id,@PathVariable("username") String username){

        return gameService.setPlayersEnrolled(id, username);
    }

}
