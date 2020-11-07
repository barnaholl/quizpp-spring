package com.theyellowpug.gamehandlerservice.repository;

import com.theyellowpug.gamehandlerservice.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {
    Game getById(Long id);

    List<Game> findAllByExpiryDateLessThan(LocalDateTime localDateTime);
}
