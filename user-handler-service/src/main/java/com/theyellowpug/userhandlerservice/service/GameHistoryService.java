package com.theyellowpug.userhandlerservice.service;

import com.theyellowpug.userhandlerservice.repository.GameHistoryRepository;

public class GameHistoryService {
    private final GameHistoryRepository gameHistoryRepository;

    public GameHistoryService(GameHistoryRepository gameHistoryRepository) {
        this.gameHistoryRepository = gameHistoryRepository;
    }

}
