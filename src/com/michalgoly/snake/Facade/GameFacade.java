package com.michalgoly.snake.Facade;

import com.michalgoly.snake.builder.GameConfig;
import com.michalgoly.snake.Game;
import com.michalgoly.snake.GameField;
import com.michalgoly.snake.ScorePanel;
import com.michalgoly.snake.Snake;
import com.michalgoly.snake.SnakeFrame;
import com.michalgoly.snake.Direction;

public class GameFacade {

    private final GameField gameField;
    private final ScorePanel scorePanel;
    private final SnakeFrame frame;
    private final GameConfig config;

    private Snake snake;
    private Game game;
    private Thread thread;

    public GameFacade(
            GameField gameField,
            ScorePanel scorePanel,
            SnakeFrame frame,
            GameConfig config) {

        this.gameField = gameField;
        this.scorePanel = scorePanel;
        this.frame = frame;
        this.config = config;

        createGame();
    }

    private void createGame() {
        snake = new Snake(gameField, scorePanel);
        game = new Game(gameField, snake, frame, config);
        thread = new Thread(game);
    }

   public void startGame() {
    if (thread != null && !thread.isAlive()) {
        thread.start();
    }
}

    public void changeDirection(Direction direction) {
        if (snake != null) {
            snake.changeDirection(direction);
        }
    }

    public void restartGame() {
        // Reset the game state
        snake = null;
        game = null;
        thread = null;

        scorePanel.clear();
        gameField.initDefaults();

        // Create a fresh game and thread
        createGame();

        scorePanel.repaint();
        gameField.repaint();
    }
}
