package com.theyellowpug.gamehandlerservice;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import com.theyellowpug.gamehandlerservice.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GameHandlerServiceApplicationTests {

	//@MockBean
	//private GameRepository gameRepository;

	@Autowired
	private GameService gameService;


	@Test
	public void getAllGamesSize1() {
		List<Game> games=gameService.getAllGames();
		assertThat(games.size()).isEqualTo(1);
	}
	@Test
	public void getAllGamesReturnWithGame(){
		List<Game> games=gameService.getAllGames();
		assertThat(games.get(0)).isInstanceOf(Game.class);
	}

}
