package com.michalgoly.snake.builder;

public class GameConfig {

    private final int delay;
    private final int panelWidth;
    private final int panelHeight;

    public GameConfig(int delay, int panelWidth, int panelHeight) {
        this.delay = delay;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    public int getDelay() {
        return delay;
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }
}
