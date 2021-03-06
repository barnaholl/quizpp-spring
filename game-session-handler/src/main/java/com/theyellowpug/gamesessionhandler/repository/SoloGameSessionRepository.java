package com.theyellowpug.gamesessionhandler.repository;

import com.theyellowpug.gamesessionhandler.entity.SoloGameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoloGameSessionRepository extends JpaRepository<SoloGameSession,Long> {
    SoloGameSession getById(Long id);

    Boolean existsByGameIdAndUsername(Long gameId, String username);

    SoloGameSession findByGameIdAndUsername(Long gameId, String username);
}
