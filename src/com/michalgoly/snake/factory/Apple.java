package com.michalgoly.snake.factory;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * [Factory Method - ConcreteProduct]
 * 
 * @author Michal Goly
 */
public class Apple extends Fruit {
	
	Apple() {
	}

	@Override
	public int getPoints() {
		return 10;
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setPaint(Color.WHITE);
		g2.fillOval((int) getShape().getMinX() + 5,
				(int) getShape().getMinY() + 5, 10, 10);
	}
}
