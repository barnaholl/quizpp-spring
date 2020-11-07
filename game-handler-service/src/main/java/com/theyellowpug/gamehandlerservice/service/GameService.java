package com.theyellowpug.gamehandlerservice.service;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Game getGameById(Long id){
        return gameRepository.getById(id);
    }

    public String createGame(Game game){
        game.setExpiryDate(LocalDateTime.now().plusHours(2));
        gameRepository.save(game);
        return game.getTitle()+" game is created";
    }

    public String deleteGameById(Long id){
        gameRepository.deleteById(id);
        return "Game at id: "+id+" is successfully deleted";
    }

    public String setPlayersEnrolled(Long id, String username){
        Game currentGame=gameRepository.getById(id);
        List<String> playersEnrolled=currentGame.getPlayersEnrolled();
        playersEnrolled.add(username);
        currentGame.setPlayersEnrolled(playersEnrolled);
        gameRepository.save(currentGame);

        return "User: " +username+" is enrolled "+currentGame.toString();
    }


}
