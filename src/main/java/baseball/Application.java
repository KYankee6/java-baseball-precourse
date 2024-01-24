package baseball;

import static baseball.game.GameStatus.*;

import baseball.game.Game;
import baseball.game.GameService;
import baseball.player.Computer;
import baseball.player.User;

public class Application {
	public static void main(String[] args) {
		Game game = new Game();
		GameService gameService = new GameService(new User(), new Computer());
		game.initialize(gameService);


		while (true) {
			if (game.getGameStatus() == INITIALIZE) {
				//TODO computer generate random String
			}

			try {
				gameService.userTurn();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

			if (game.getGameStatus() == STOP) {
				gameService.askUser();
			}

			if (game.getGameStatus() == EXIT) {
				return;
			}

		}
	}
}
