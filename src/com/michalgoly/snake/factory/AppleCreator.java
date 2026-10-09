package com.michalgoly.snake.factory;

import com.michalgoly.snake.Apple;
import com.michalgoly.snake.GameObject;

/**
 * [Factory Method - ConcreteCreator]
 * Creates a normal apple (10 points) at the default start position.
 */
public class AppleCreator extends GameObjectCreator {

	@Override
	protected GameObject createGameObject() {
		return new Apple(100, 100);
	}
}
