package com.STD22073.game;

import com.STD22073.model.*;
import com.STD22073.state.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SnakeGame {
    private static final int GRID_SIZE = 10;
    private Snake snake;
    private Point food;
    private int score = 0;
    private final FoodFactory foodFactory = new FoodFactory();
    private GameState currentState;
    private final Scanner scanner = new Scanner(System.in);

    public SnakeGame() {
        initializeGame();
        currentState = new MenuState();
    }

    private void initializeGame() {
        snake = new SnakeBuilder()
                .setInitialBody(Arrays.asList(
                        new Point(2, 2),
                        new Point(1, 2),
                        new Point(0, 2)
                ))
                .setInitialDirection(Direction.RIGHT)
                .build();

        food = foodFactory.generateFood(snake, GRID_SIZE);
        score = 0;
    }

    public void run() throws InterruptedException {
        while (true) {
            clearConsole();
            currentState.render(this);

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    currentState.handleInput(this, input.substring(0, 1));
                }
            }

            currentState.update(this);
            TimeUnit.MILLISECONDS.sleep(300);
        }
    }

    private void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(50));
        }
    }

    public void changeState(GameState newState) {
        this.currentState = newState;
    }

    public void reset() {
        initializeGame();
    }

    public void incrementScore() {
        score++;
    }

    public Snake getSnake() { return snake; }
    public Point getFood() { return food; }
    public int getScore() { return score; }
    public int getGridSize() { return GRID_SIZE; }
    public FoodFactory getFoodFactory() { return foodFactory; }
    public void setFood(Point food) { this.food = food; }
}