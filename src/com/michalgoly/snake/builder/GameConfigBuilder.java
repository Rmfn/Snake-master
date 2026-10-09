package com.michalgoly.snake.builder;

public interface GameConfigBuilder {

    GameConfigBuilder setDelay(int delay);

    GameConfigBuilder setPanelWidth(int panelWidth);

    GameConfigBuilder setPanelHeight(int panelHeight);

    GameConfig build();
}
