package com.michalgoly.snake.decorator;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

/**
 * Component
 * Anything that can draw the snake.
 */

public interface SnakeRenderer {

    /**
	 * Draws the snake.
	 * @param g2 The graphics of the GameField
	 * @param parts The snake parts, the head is parts.get(0)
	 */

    void draw(Graphics2D g2, List<Ellipse2D.Double> parts);
}
