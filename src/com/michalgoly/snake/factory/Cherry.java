package com.michalgoly.snake.factory;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * [Factory Method - ConcreteProduct]
 * A pink fruit worth 50 points.
 */
public class Cherry extends Fruit {

	Cherry() {
	}

	@Override
	public int getPoints() {
		return 50;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setPaint(new Color(255, 80, 200)); // PINK
		g2.fillOval((int) getShape().getMinX() + 3,
				(int) getShape().getMinY() + 3, 14, 14);
	}
}
