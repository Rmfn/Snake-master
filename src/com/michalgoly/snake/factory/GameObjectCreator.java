package com.michalgoly.snake.factory;

import com.michalgoly.snake.GameField;
import com.michalgoly.snake.GameObject;

/**
 * [Factory Method - Creator]
 * Declares the factory method createGameObject() and lets subclasses
 * decide which concrete GameObject to instantiate.
 */
public abstract class GameObjectCreator {

	/**
	 * The factory method. Each ConcreteCreator overrides it to create
	 * exactly one kind of product.
	 */
	protected abstract GameObject createGameObject();

	/**
	 * [AnOperation] Shared logic that works with ANY product without
	 * knowing its concrete class: create it and register it on the field
	 * so it gets drawn.
	 */
	public GameObject spawn(GameField gameField) {
		GameObject gameObject = createGameObject();
		gameField.addGameObject(gameObject);
		return gameObject;
	}
}
