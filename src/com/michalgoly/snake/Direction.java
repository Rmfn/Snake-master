package com.michalgoly.snake;

/**
 * Enumeration data type which describes one of the 4 possible directions
 * snake can move. 
 * 
 * @author Michal Goly
 */
public enum Direction {
	UP, DOWN, LEFT, RIGHT;

	/**
	 * @return the direction the snake can never turn to from this one
	 */
	public Direction opposite() {
		switch (this) {
			case UP:    return DOWN;
			case DOWN:  return UP;
			case LEFT:  return RIGHT;
			default:    return LEFT;
		}
	}

}
