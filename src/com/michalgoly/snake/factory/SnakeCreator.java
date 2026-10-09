package com.michalgoly.snake.factory;

import com.michalgoly.snake.GameField;
import com.michalgoly.snake.GameObject;
import com.michalgoly.snake.ScorePanel;
import com.michalgoly.snake.Snake;

/**
 * [Factory Method - ConcreteCreator]
 * Creates the snake with its default body parts.
 */
public class SnakeCreator extends GameObjectCreator {

	private GameField gameField;
	private ScorePanel scorePanel;

	public SnakeCreator(GameField gameField, ScorePanel scorePanel) {
		this.gameField = gameField;
		this.scorePanel = scorePanel;
	}

	@Override
	protected GameObject createGameObject() {
		return new Snake(gameField, scorePanel);
	}
}
