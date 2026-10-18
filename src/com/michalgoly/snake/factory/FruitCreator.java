package com.michalgoly.snake.factory;
import com.michalgoly.snake.GameField;
import com.michalgoly.snake.Snake;

/**
 * [Factory Method - Creator]
 * Declares the factory method createFruit() and lets subclasses decide
 * which fruit to instantiate.
 */
public abstract class FruitCreator {

	/**
	 * FactoryMethod(): each ConcreteCreator returns its own fruit
	 */
	protected abstract Fruit createFruit();

	/**
	 * AnOperation(): the main work of the creator. It works with any fruit
	 * through the Fruit type, without knowing its actual class:
	 * create it, move it away from the snake, and put it on the field.
	 * @return the fruit that was placed on the field
	 */
	public Fruit spawnFruit(GameField gameField, Snake snake) {
		Fruit fruit = createFruit();
		fruit.next(snake); 
		gameField.addFruit(fruit);
		return fruit;
	}
}

