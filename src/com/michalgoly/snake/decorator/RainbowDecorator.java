package com.michalgoly.snake.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

/**
 * ConcreteDecorator
 * Adds a rainbow rim around the snake after eating a banana
 */

public class RainbowDecorator extends SnakeRendererDecorator{

    private static final Color[] COLORS = { 
		new Color(255, 200, 40),
        new Color(150, 220, 60),
        new Color(80, 225, 160),
        new Color(165, 100, 255) }; 
 
	public RainbowDecorator(SnakeRenderer decoratedRenderer) {
		super(decoratedRenderer);
	}
 
	@Override
	public void draw(Graphics2D g2, List<Ellipse2D.Double> parts) {
		for (int i = 0; i < parts.size(); i++) {
			Ellipse2D.Double part = parts.get(i);
			g2.setPaint(COLORS[i % COLORS.length]); // repeat the colours along the body
			g2.fill(new Ellipse2D.Double(part.x - 4, part.y - 4, 28, 28));  // 4 px bigger on each side
		}
		decoratedRenderer.draw(g2, parts); // draw the snake on top
	}
    
}
