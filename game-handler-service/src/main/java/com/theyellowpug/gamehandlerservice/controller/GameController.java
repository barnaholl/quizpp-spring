package com.theyellowpug.gamehandlerservice.controller;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

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
