package com.michalgoly.snake.state;

import com.michalgoly.snake.Direction;
import com.michalgoly.snake.SnakeFrame;

/**
 * [State - ConcreteState]
 * The game is paused: the snake does not move and the timers stop.
 */
public class PausedState implements GameState {

    @Override
    public void arrowPressed(SnakeFrame context, Direction direction) {
        // Arrows are ignored while paused
    }

    @Override
    public void pausePressed(SnakeFrame context) {
        context.resumeGame();
        context.setState(new PlayingState());
    }

    @Override
    public String getStatusText() {
        return "PAUSED";
    }
}