package com.michalgoly.snake.factory;
/**
 * [Factory Method - ConcreteCreator]
 */
public class AppleCreator extends FruitCreator{
    @Override
	protected Fruit createFruit() {
		return new Apple();
	}
}
