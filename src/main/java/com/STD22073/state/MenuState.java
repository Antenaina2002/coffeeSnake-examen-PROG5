package com.STD22073.state;


import com.STD22073.game.SnakeGame;

public class MenuState implements GameState {
    @Override
    public void handleInput(SnakeGame game, String input) {
        if (" ".equals(input)) {
            game.changeState(new RunningState());
        }
    }

    @Override
    public void update(SnakeGame game) {}

    @Override
    public void render(SnakeGame game) {
        System.out.println("\n=== SNAKE GAME ===");
        System.out.println("Appuyez sur [ESPACE] pour commencer");
        System.out.println("Contrôles: W (haut), S (bas), A (gauche), D (droite)");
    }
}