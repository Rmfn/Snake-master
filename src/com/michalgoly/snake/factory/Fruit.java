package com.michalgoly.snake.factory;

import com.michalgoly.snake.Snake;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
// product
public abstract class Fruit {

    public static final int XSIZE = 20;
	public static final int YSIZE = 20;

	private double x;
	private double y;

	/**
	 * Creates a fruit at a random position on the field
	 */
	protected Fruit() {
		this.x = getNew();
		this.y = getNew();
	}

	/**
	 * @return The points the player gets for eating this fruit
	 */
	public abstract int getPoints();

	/**
	 * Draws the fruit, each fruit looks different
	 */
	public abstract void draw(Graphics2D g2);

	/**
	 * Generates new coordinates for the fruit, so it does not appear on
	 * top of the snake
	 * @param snake The snake
	 */
	public void next(Snake snake) {
		for (Ellipse2D.Double e : snake.getParts()) {
			while (x == e.getMinX() && y == e.getMinY()) {
				x = getNew();
				y = getNew();
			}
		}
	}

	/*
	 * Generates a random number which can be used as a valid coordinate
	 */
	private double getNew() {
		double d = 1111;
		while (d >= 400 || d % 20 != 0) {
			d = Math.random() * 1000;
			d = (int) d;
		}
		return d;
	}

	/**
	 * @return The shape of the fruit
	 */
	public Ellipse2D.Double getShape() {
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
    
}
