package baseball.game;

import static baseball.game.GameStatus.*;

public class Game {
    private GameStatus gameStatus;

    public void initialize() {
        this.setGameStatus(INITIALIZE);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
