package com.michalgoly.snake.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

/**
 * ConcreteComponent
 * Draws the original snake: a blue body and a red head.
 * This code was moved here from GameField.paintComponent().
 */

public class BasicSnakeRenderer implements SnakeRenderer {

    private static final Color BODY = new Color(34, 136, 215);  // BLUE
	private static final Color HEAD = new Color(215, 34, 38);   // RED
 
	@Override
	public void draw(Graphics2D g2, List<Ellipse2D.Double> parts) {
		g2.setPaint(BODY);
		for (Ellipse2D e : parts) {
			g2.fill(e);
		}
		g2.setPaint(HEAD);
		g2.fill(parts.get(0));
	}
    
}
