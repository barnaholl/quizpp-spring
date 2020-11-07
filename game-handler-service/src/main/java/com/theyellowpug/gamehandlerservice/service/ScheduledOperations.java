package com.theyellowpug.gamehandlerservice.service;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ScheduledOperations {

    private long counter=0;

    private final GameRepository gameRepository;

    public ScheduledOperations(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Scheduled(initialDelay = 60*1000L,fixedDelay = 180*1000L)
    private void createGame(){
        Game game= Game.builder()
                .title("Game number "+counter)
                .difficulty((short) 1)
                .tag("general")
                .type("free")
                .description("Game will expire at: " +LocalDateTime.now().plusMinutes(2))
                .expiryDate(LocalDateTime.now().plusMinutes(5))
                .build();

        gameRepository.save(game);
        counter++;

    }
    @Scheduled(fixedDelay = 300*1000L)
    private void cleanUp(){
        List<Game> expiredGames=gameRepository.findAllByExpiryDateLessThan(LocalDateTime.now());
        gameRepository.deleteAll(expiredGames);
    }
}
