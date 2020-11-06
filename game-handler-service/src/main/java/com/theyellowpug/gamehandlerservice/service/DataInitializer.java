package com.theyellowpug.gamehandlerservice.service;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer implements CommandLineRunner {
    private final GameRepository gameRepository;

    public DataInitializer(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public  void createGame(String title,String description,String tag,String type,short difficulty){
        Game game= Game.builder().title(title).description(description).tag(tag).type(type).difficulty(difficulty).build();
        gameRepository.save(game);
    }

    @Override
    public void run(String... args){
        //createGame("My first game ever","This is the first game of QuizPP","general","free",(short)1);
    }
}
