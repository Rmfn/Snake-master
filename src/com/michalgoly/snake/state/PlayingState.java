package com.michalgoly.snake.state;

import com.michalgoly.snake.Direction;
import com.michalgoly.snake.SnakeFrame;

/**
 * [State - ConcreteState]
 * The snake is moving.
 */
public class PlayingState implements GameState {

    @Override
    public void arrowPressed(SnakeFrame context, Direction direction) {
        // The snake can never turn back on itself
        if (direction == context.getDirection().opposite()) {
            return;
        }
        context.changeDirection(direction);
    }

    @Override
    public void pausePressed(SnakeFrame context) {
        context.pauseGame();
        context.setState(new PausedState());
    }

    @Override
    public String getStatusText() {
        return null;
    }
}