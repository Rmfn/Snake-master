package com.michalgoly.snake;

import java.awt.Graphics2D;

/**
 * [Factory Method - Product]
 * Common interface for every object that lives on the game field and
 * knows how to draw itself. The field only depends on this interface,
 * never on the concrete classes (Snake, Apple).
 */
public interface GameObject {
	void draw(Graphics2D g2);
}
