package baseball;

import static baseball.game.GameStatus.*;

import baseball.game.Game;
import baseball.game.GameService;
import baseball.player.Computer;
import baseball.player.User;

public class Application {
	public static void main(String[] args) {
		Game game = new Game();
		game.initialize();
		GameService gameService = new GameService(game, new User(), new Computer());

		while (true) {
			if (game.getGameStatus() == INITIALIZE) {
				game.play();
				gameService.generateRandom();
			}


			try {
				gameService.userTurn();
			} catch (Exception e) {
				throw new IllegalArgumentException(e);
			}

			if (game.getGameStatus() == PLAYING) {
				gameService.judge();
			}

			if (game.getGameStatus() == STOP) {
				gameService.askUserWantToPlay();
			}

			if (game.getGameStatus() == EXIT) {
				return;
			}

		}
	}
}
