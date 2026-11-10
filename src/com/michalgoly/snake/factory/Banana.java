package com.michalgoly.snake.factory;
import java.awt.Color;
import java.awt.Graphics2D;

import com.michalgoly.snake.SnakeEffects;

/**
 * [Factory Method - ConcreteProduct]
 * A yellow fruit worth 20 points.
 */
public class Banana extends Fruit{
    Banana() {
	}

	@Override
	public int getPoints() {
		return 20;
	}

	@Override
	public void applyEffect(SnakeEffects effects) {
		effects.addRainbow();
	}

	@Override
	public void draw(Graphics2D g2) {
		g2.setPaint(Color.YELLOW);
		g2.fillOval((int) getShape().getMinX() + 2,
				(int) getShape().getMinY() + 6, 16, 8);
	}
}
