package com.theyellowpug.userhandlerservice.repository;

import com.theyellowpug.userhandlerservice.entity.GamesPlayed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesPlayedRepository extends JpaRepository<GamesPlayed,Long> {
}
