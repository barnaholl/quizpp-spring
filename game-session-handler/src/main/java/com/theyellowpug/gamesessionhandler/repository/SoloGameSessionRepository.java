package com.theyellowpug.gamesessionhandler.repository;

import com.theyellowpug.gamesessionhandler.entity.SoloGameSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoloGameSessionRepository extends JpaRepository<SoloGameSession,Long> {
    SoloGameSession getById(Long id);

    Boolean existsByGameIdAndUsername(Long gameId, String username);

    Optional<SoloGameSession> findByGameIdAndUsername(Long gameId, String username);
}
