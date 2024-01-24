package baseball.game;

import static baseball.game.GameStatus.*;

public class Game {
    private GameService gameService;
    private GameStatus gameStatus;

    public void initialize(GameService gameService) {
        this.setGameService(gameService);
        this.setGameStatus(INITIALIZE);
    }

    public void play() {
        this.setGameStatus(PLAYING);
    }
    public void stop() {
        this.setGameStatus(STOP);
    }



    public GameStatus getGameStatus() {
        return gameStatus;
    }


    private void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameService getGameService() {
        return gameService;
    }

    private void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
