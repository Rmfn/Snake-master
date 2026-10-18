package com.michalgoly.snake.factory;

/**
 * [Factory Method - ConcreteCreator]
 */
public class CherryCreator extends FruitCreator {

	@Override
	protected Fruit createFruit() {
		return new Cherry();
	}
}
