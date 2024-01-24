package baseball.game;

import static baseball.game.GameStatus.*;

public class Game {
    private GameStatus gameStatus;

    public void initialize() {
        this.setGameStatus(INITIALIZE);
    }

    public void play() {
        this.setGameStatus(PLAYING);
    }
    public void stop() {
        this.setGameStatus(STOP);
    }

    public void exit() {
        this.setGameStatus(EXIT);
    }



    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

}
