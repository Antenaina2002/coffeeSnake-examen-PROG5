package com.STD22073.state;

import com.STD22073.game.SnakeGame;

public interface GameState {
    void handleInput(SnakeGame game, String input);
    void update(SnakeGame game);
    void render(SnakeGame game);
}