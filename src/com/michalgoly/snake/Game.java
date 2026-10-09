package com.michalgoly.snake;

import com.michalgoly.snake.factory.AppleCreator;
import com.michalgoly.snake.factory.GameObjectCreator;

/**
 * This class is responsible for running the game, or indeed making the
 * snake move. 
 * 
 * @author Michal Goly
 */
public class Game implements Runnable {

	// The amount of time in miliseconds between each 'tick'
	public static final int DELAY = 400;

	private SnakeFrame frame;
	private GameField gameField;
	private Snake snake;
	
	/**
	 * Constructs a new runnable Game object which can be used to create
	 * a Thread. 
	 * @param gameField The rectangular area where snake can move
	 * @param snake The snake object
	 * @param frame The frame which will be notified when the game is over
	 */
	public Game(GameField gameField, Snake snake, SnakeFrame frame) {
		this.frame = frame;
		this.snake = snake;
		this.gameField = gameField;

		// Factory Method: Game asks a creator instead of calling "new Apple"
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
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException ex) {
			frame.gameOver();
		}
	}
}
