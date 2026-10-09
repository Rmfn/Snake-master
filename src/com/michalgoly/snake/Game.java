package com.michalgoly.snake;

import com.michalgoly.snake.factory.AppleCreator;
import com.michalgoly.snake.factory.GameObjectCreator;
import com.michalgoly.snake.builder.GameConfig;

/**
 * This class is responsible for running the game, or indeed making the
 * snake move. 
 * 
 * @author Michal Goly
 */
public class Game implements Runnable {

	// The amount of time in miliseconds between each 'tick'
	private SnakeFrame frame;
	private GameField gameField;
	private Snake snake;
	private final GameConfig config;
	
	/**
	 * Constructs a new runnable Game object which can be used to create
	 * a Thread. 
	 * @param gameField The rectangular area where snake can move
	 * @param snake The snake object
	 * @param frame The frame which will be notified when the game is over
	 */
	
	public Game(GameField gameField, Snake snake,
            SnakeFrame frame, GameConfig config) {
    this.frame = frame;
    this.snake = snake;
    this.gameField = gameField;
    this.config = config;

    GameObjectCreator appleCreator = new AppleCreator();
    Apple apple = (Apple) appleCreator.spawn(gameField);
    this.gameField.setApple(apple);
}

	@Override
	public void run() {
		try {
			while (true) {
				snake.move();
				snake.check();
				if (snake.isGameOver()) {
					Thread.currentThread().interrupt();
				}
				if (!Thread.currentThread().isInterrupted()) {
					gameField.repaint();
				}
				Thread.sleep(config.getDelay());
			}
		} catch (InterruptedException ex) {
			frame.gameOver();
		}
	}
}
