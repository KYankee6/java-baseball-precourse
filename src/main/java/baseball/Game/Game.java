package baseball.Game;

import static baseball.Game.GameStatus.*;

public class Game {
    private GameStatus gameStatus;

    public void initialize() {
        this.gameStatus = INIT;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
