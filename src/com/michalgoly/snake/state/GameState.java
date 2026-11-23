package com.michalgoly.snake.state;

import com.michalgoly.snake.Direction;
import com.michalgoly.snake.SnakeFrame;

/**
 * [State - State]
 * What a key press does depends on the current state of the game.
 * Each concrete state decides its own behaviour and the next state.
 */

public interface  GameState {
    /** An arrow key was pressed. */
    void arrowPressed(SnakeFrame context, Direction direction);

    /** The P key was pressed. */
    void pausePressed(SnakeFrame context);

    /** @return the text GameField shows in this state, or null for none */
    String getStatusText();
}
