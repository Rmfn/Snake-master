package com.michalgoly.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;
import com.michalgoly.snake.builder.GameConfig;
import com.michalgoly.snake.factory.AppleCreator;
import com.michalgoly.snake.factory.BananaCreator;
import com.michalgoly.snake.factory.CherryCreator;
import com.michalgoly.snake.factory.Fruit;
import com.michalgoly.snake.factory.FruitCreator;
/**
 * GameField represents a black, rectangular area where the snake can move. 
 * It is also responsible for drawing the snake and the fruits.
 * 
 * @author Michal Goly
 */
public class GameField extends JPanel {

	// A bonus fruit appears every 10 seconds and disappears after 5 seconds
	public static final int BONUS_APPEARS_AFTER = 10000;
	public static final int BONUS_STAYS_FOR = 5000;


	// The banana or cherry on the field, or null when there is none
	private Fruit bonusFruit = null;
	// Time in milliseconds since the bonus fruit appeared or disappeared
	private int timer = 0;
	// Counts the bonus fruits, used to switch between Banana and Cherry
	private int bonusCount = 0;
	

	private GameConfig config;
	
	private List<Ellipse2D.Double> snakeParts;
	// The apple and, at bonus time, a banana or a cherry.
	// Thread-safe: the game thread adds/removes while Swing paints.
	private List<Fruit> fruits;
	private Fruit apple;
	
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
	initDefaults();
}
	/**
	 * Initializes the default snake and removes all fruits. The fruits are
	 * placed by this board through a FruitCreator in updateFruits().
	 */
	public void initDefaults() {
		fruits = new CopyOnWriteArrayList<Fruit>();
		apple = null;
        bonusFruit = null;
        timer = 0;
        bonusCount = 0;
		snakeParts = Collections
				.synchronizedList(new ArrayList<Ellipse2D.Double>());
		snakeParts.add(new Ellipse2D.Double(260, 260, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 280, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 300, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 320, 20, 20));
	}

	private FruitCreator chooseCreator() {
        if (apple == null) {
            return new AppleCreator();
        } else if (bonusCount % 2 == 1) {
            return new BananaCreator();
        } else {
            return new CherryCreator();
        }
    }

	 public void updateFruits(Snake snake, int elapsed) {
        if (apple == null) {
            apple = chooseCreator().spawnFruit(this, snake);
        }
        timer += elapsed;
        if (bonusFruit == null && timer >= BONUS_APPEARS_AFTER) {
            bonusCount++;
            timer = 0;
            bonusFruit = chooseCreator().spawnFruit(this, snake);
        } else if (bonusFruit != null && timer >= BONUS_STAYS_FOR) { 
            fruits.remove(bonusFruit);
            bonusFruit = null;
            timer = 0;
        }
    }

	public void fruitEaten(Fruit fruit) {
        fruits.remove(fruit);
        if (fruit == apple) {
            apple = null;
        } else if (fruit == bonusFruit) {
            bonusFruit = null;
            timer = 0;
        }
    }

	public void setSnakeParts(List<Ellipse2D.Double> snakeParts) {
		this.snakeParts = snakeParts;
	}

	public void addFruit(Fruit fruit) {
		fruits.add(fruit);
	}


	public List<Fruit> getFruits() {
		return fruits;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw the fruits, each fruit draws itself differently
		for (Fruit fruit : fruits) {
			fruit.draw(g2);
		}
		// Draw the snake parts
		g2.setPaint(new Color(34, 136, 215)); // BLUE
		for (Ellipse2D e : snakeParts) {
			g2.fill(e);
		}
		// Draw the head of the snake
		g2.setPaint(new Color(215, 34, 38));  // RED
		g2.fill(snakeParts.get(0));
	}
}
