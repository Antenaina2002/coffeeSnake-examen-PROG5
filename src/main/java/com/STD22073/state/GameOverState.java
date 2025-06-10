package com.STD22073.state;

import com.STD22073.game.SnakeGame;

public class GameOverState implements GameState {
    @Override
    public void handleInput(SnakeGame game, String input) {
        if ("r".equals(input.toLowerCase())) {
            game.reset();
            game.changeState(new RunningState());
        } else if ("q".equals(input.toLowerCase())) {
            System.exit(0);
        }
    }

    @Override
    public void update(SnakeGame game) {}

    @Override
    public void render(SnakeGame game) {
        System.out.println("\n=== GAME OVER ===");
        System.out.println("Score final: " + game.getScore());
        System.out.println("Appuyez sur [R] pour recommencer");
        System.out.println("Appuyez sur [Q] pour quitter");
    }
}