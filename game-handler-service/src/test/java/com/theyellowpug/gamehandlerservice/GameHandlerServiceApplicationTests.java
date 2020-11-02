package com.theyellowpug.gamehandlerservice;

import com.theyellowpug.gamehandlerservice.entity.Game;
import com.theyellowpug.gamehandlerservice.repository.GameRepository;
import com.theyellowpug.gamehandlerservice.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GameHandlerServiceApplicationTests {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameService gameService;


	@Test
	public void getAllGamesSizeTest() {
		List<Game> games=gameService.getAllGames();
		assertThat(games.size()).isEqualTo(1);
	}
	@Test
	public void getAllGamesReturnWithGameTest(){
		List<Game> games=gameService.getAllGames();
		assertThat(games.get(0)).isInstanceOf(Game.class);
	}

	@Test
	public void createGameSizeTest(){
		gameService.createGame(Game.builder().title("test").tag("test").type("test").difficulty((short)1).description("test").build());
		List<Game> games=gameRepository.findAll();

		assertThat(games.size()).isEqualTo(2);
	}

	@Test
	public void createGameObjectQualityTest() {
		Game game=Game.builder().title("test").tag("test").type("test").difficulty((short)1).description("test").playersEnrolled(null).build();
		gameService.createGame(game);

		assertThat(gameRepository.findAll().get(1).getTitle()).isEqualTo(game.getTitle());
	}


}
