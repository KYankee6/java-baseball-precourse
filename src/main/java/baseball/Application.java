package baseball;

import static baseball.game.GameStatus.*;

import baseball.game.Game;

public class Application {
	public static void main(String[] args) {
		Game game = new Game();
		game.initialize();
		while (true) {
			if (game.getGameStatus() == INITIALIZE) {
				//TODO computer generate random String
			}

			if (game.getGameStatus() == PLAYING) {
				//TODO user guess random string and computer replies
			}

			if (game.getGameStatus() == STOP) {
				//TODO print hurray and ask for the next game
			}

			if (game.getGameStatus() == EXIT) {
				return;
			}

		}
	}
}
