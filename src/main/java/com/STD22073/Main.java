package com.STD22073;

import com.STD22073.game.SnakeGame;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║    SNAKE GAME - JAVA       ║");
            System.out.println("╚════════════════════════════╝");
            System.out.println("\nContrôles :");
            System.out.println("- [ESPACE] : Démarrer");
            System.out.println("- W/A/S/D  : Directions");
            System.out.println("- R        : Recommencer");
            System.out.println("- Q        : Quitter\n");

            TimeUnit.SECONDS.sleep(2); // Pause pour laisser lire les instructions

            SnakeGame game = new SnakeGame();
            game.run();

        } catch (InterruptedException e) {
            System.err.println("Le jeu a été interrompu");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Erreur inattendue : " + e.getMessage());
            e.printStackTrace();
        }
    }
}