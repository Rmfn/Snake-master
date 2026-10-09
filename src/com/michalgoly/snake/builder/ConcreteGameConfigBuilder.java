package com.michalgoly.snake.builder;

public class ConcreteGameConfigBuilder implements GameConfigBuilder {

    private int delay = 400;
    private int panelWidth = 400;
    private int panelHeight = 400;

    @Override
    public GameConfigBuilder setDelay(int delay) {
        this.delay = delay;
        return this;
    }

    @Override
    public GameConfigBuilder setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
        return this;
    }

    @Override
    public GameConfigBuilder setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
        return this;
    }

    @Override
    public GameConfig build() {
        return new GameConfig(delay, panelWidth, panelHeight);
    }
}
