package com.theyellowpug.gamehandlerservice.repository;

import com.theyellowpug.gamehandlerservice.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
    Game getById(Long id);
}