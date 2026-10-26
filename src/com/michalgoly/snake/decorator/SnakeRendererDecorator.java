package com.michalgoly.snake.decorator;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

/**
 * Decorator
 * Keeps a reference to the wrapped renderer and forwards draw() to it.
 * Concrete decorators add their own drawing before or after.
 */

public abstract class SnakeRendererDecorator implements SnakeRenderer{
    protected final SnakeRenderer decoratedRenderer;
 
	protected SnakeRendererDecorator(SnakeRenderer decoratedRenderer) {
		this.decoratedRenderer = decoratedRenderer;
	}
 
	@Override
	public void draw(Graphics2D g2, List<Ellipse2D.Double> parts) {
		decoratedRenderer.draw(g2, parts);
	}
}
