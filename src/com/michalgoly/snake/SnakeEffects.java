package com.michalgoly.snake;


import com.michalgoly.snake.decorator.BasicSnakeRenderer;
import com.michalgoly.snake.decorator.EyesDecorator;
import com.michalgoly.snake.decorator.RainbowDecorator;
import com.michalgoly.snake.decorator.SnakeRenderer;
import com.michalgoly.snake.factory.Banana;
import com.michalgoly.snake.factory.Cherry;
import com.michalgoly.snake.factory.Fruit;

/**
 * Decides which snake effects (decorators) are active and for how long,
 * and gives GameField the matching decorated renderer.
 */
public class SnakeEffects {

	// 20s
	private static final int EFFECT_MS = 20000;

	private final GameField gameField;
	private final int ticksPerEffect;

	// Remaining game ticks for each effect, 0 = not active
	private int rainbowTicksLeft = 0;
	private int eyesTicksLeft = 0;

	/**
	 * @param gameField The field that draws the snake
	 * @param delay The time of one game tick in milliseconds
	 */
	public SnakeEffects(GameField gameField, int delay) {
		this.gameField = gameField;
		this.ticksPerEffect = EFFECT_MS / delay;
	}

	/**
	 * Attaches an effect. Eating the same fruit again restarts its 20 seconds.
	 */
	public void fruitEaten(Fruit eaten) {
		if (eaten instanceof Banana) {
			rainbowTicksLeft = ticksPerEffect;
		} else if (eaten instanceof Cherry) {
			eyesTicksLeft = ticksPerEffect;
		} else {
			return; // an apple has no effect
		}
		rebuildRenderer();
	}

	/**
	 * Called once per game tick. When an effect runs out it is withdrawn.
	 */
	public void tick() {
		boolean expired = false;
		
		if (rainbowTicksLeft > 0 && --rainbowTicksLeft == 0) {
			expired = true;
		}
		if (eyesTicksLeft > 0 && --eyesTicksLeft == 0) {
			expired = true;
		}
		if (expired) {
			rebuildRenderer();
		}
	}

	/**
	 * Wraps the basic renderer in the decorators that are active right now.
	 * With both effects active this builds: new EyesDecorator(new RainbowDecorator(new BasicSnakeRenderer()))
	 * Withdrawing an effect = rebuilding the layers without it.
	 */
	private void rebuildRenderer() {
		SnakeRenderer renderer = new BasicSnakeRenderer();
		if (rainbowTicksLeft > 0) {
			renderer = new RainbowDecorator(renderer);
		}
		if (eyesTicksLeft > 0) {
			renderer = new EyesDecorator(renderer);
		}
		gameField.setSnakeRenderer(renderer);
	}
}
