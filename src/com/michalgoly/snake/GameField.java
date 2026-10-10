package com.michalgoly.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.michalgoly.snake.builder.GameConfig;

import javax.swing.JPanel;

/**
 * GameField represents a black, rectangular area where the snake can move. 
 * It draws every GameObject registered on it, without knowing their
 * concrete classes.
 * 
 * @author Michal Goly
 */
public class GameField extends JPanel {
	

	private GameConfig config;
	
	// Thread-safe: the game thread adds/removes while Swing paints
	private List<GameObject> gameObjects = new CopyOnWriteArrayList<GameObject>();
	private Apple apple;
	
	/**
	 * Constructs the game field, which is the rectangular area where snake can
	 * move
	 */
	public GameField(GameConfig config) {
    this.config = config;

    setPreferredSize(new Dimension(
        config.getPanelWidth(),
        config.getPanelHeight()
    ));

    setBackground(Color.BLACK);
}
	
	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}
	
	/**
	 * Removes all objects, used when a new game starts
	 */
	public void clearGameObjects() {
		gameObjects.clear();
		apple = null;
	}
	
	public void setApple(Apple apple) {
		this.apple = apple;
	}
	
	public Apple getApple() {
		return apple;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Polymorphism: every object draws itself
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(g2);
		}
	}
}
