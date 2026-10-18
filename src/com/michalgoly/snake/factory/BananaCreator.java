package com.michalgoly.snake.factory;

/**
 * [Factory Method - ConcreteCreator]
 */
public class BananaCreator extends FruitCreator {

	@Override
	protected Fruit createFruit() {
		return new Banana();
	}
}