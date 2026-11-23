package com.michalgoly.snake.state;

import com.michalgoly.snake.Direction;
import com.michalgoly.snake.SnakeFrame;

/**
 * [State - ConcreteState]
 * The game is waiting for the first arrow key.
 */
public class ReadyState implements GameState {

    @Override
    public void arrowPressed(SnakeFrame context, Direction direction) {
        // The snake starts facing UP with its body below the head,
        // so DOWN would make it eat itself on the first move.
        if (direction == context.getDirection().opposite()) {
            return;
        }
        context.changeDirection(direction);
        context.startGame();
        context.setState(new PlayingState());
    }

    @Override
    public void pausePressed(SnakeFrame context) {
        // Nothing to pause before the game starts
    }

    @Override
    public String getStatusText() {
        return "Press an arrow key to start";
    }
}
