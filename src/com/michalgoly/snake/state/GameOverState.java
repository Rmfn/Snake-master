package com.michalgoly.snake.state;

import com.michalgoly.snake.Direction;
import com.michalgoly.snake.SnakeFrame;

/**
 * [State - ConcreteState]
 * The snake hit a wall or itself
 */
public class GameOverState implements GameState {

    @Override
    public void arrowPressed(SnakeFrame context, Direction direction) {
        // Ignored, the game has ended
    }

    @Override
    public void pausePressed(SnakeFrame context) {
        // Ignored, there is nothing to pause
    }

    @Override
    public String getStatusText() {
        return "GAME OVER";
    }
}