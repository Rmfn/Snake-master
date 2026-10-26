package com.michalgoly.snake.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

/**
 * ConcreteDecorator
 * Adds two eyes on the snake's head after eating a cherry.
 */

public class EyesDecorator extends SnakeRendererDecorator {

	public EyesDecorator(SnakeRenderer decoratedRenderer) {
		super(decoratedRenderer);
	}

	@Override
	public void draw(Graphics2D g2, List<Ellipse2D.Double> parts) {
		decoratedRenderer.draw(g2, parts);   //  draw the snake first

		Ellipse2D.Double head = parts.get(0);
		double x = head.x;
		double y = head.y;
 
		g2.setPaint(Color.WHITE);
		g2.fill(new Ellipse2D.Double(x + 2, y + 4, 8, 8));
		g2.fill(new Ellipse2D.Double(x + 10, y + 4, 8, 8));
 
		g2.setPaint(Color.BLACK);
		g2.fill(new Ellipse2D.Double(x + 4, y + 6, 4, 4));
		g2.fill(new Ellipse2D.Double(x + 12, y + 6, 4, 4));
	}
}
