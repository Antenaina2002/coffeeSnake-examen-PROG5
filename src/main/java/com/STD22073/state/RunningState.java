package com.STD22073.state;

import com.STD22073.game.SnakeGame;
import com.STD22073.model.Direction;
import com.STD22073.model.Point;

import java.util.List;

public class RunningState implements GameState {
    @Override
    public void handleInput(SnakeGame game, String input) {
        Direction newDirection = switch (input.toLowerCase()) {
            case "w" -> Direction.UP;
            case "s" -> Direction.DOWN;
            case "a" -> Direction.LEFT;
            case "d" -> Direction.RIGHT;
            default -> null;
        };
        if (newDirection != null) {
            game.getSnake().setDirection(newDirection);
        }
    }

    @Override
    public void update(SnakeGame game) {
        game.getSnake().move();
        Point head = game.getSnake().getHead();
        int gridSize = game.getGridSize();

        // Collision avec les murs
        if (head.getX() < 0 || head.getX() >= gridSize ||
                head.getY() < 0 || head.getY() >= gridSize) {
            game.changeState(new GameOverState());
            return;
        }

        List<Point> body = game.getSnake().getBody();
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                game.changeState(new GameOverState());
                return;
            }
        }

        if (head.equals(game.getFood())) {
            game.getSnake().grow();
            game.incrementScore();
            game.setFood(game.getFoodFactory().generateFood(game.getSnake(), gridSize));
        }
    }

    @Override
    public void render(SnakeGame game) {
        System.out.println("\nScore: " + game.getScore());
        renderGrid(game);
    }

    private void renderGrid(SnakeGame game) {
        int gridSize = game.getGridSize();
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                Point p = new Point(x, y);
                if (game.getSnake().getHead().equals(p)) {
                    System.out.print("H ");
                } else if (game.getSnake().contains(p)) {
                    System.out.print("* ");
                } else if (p.equals(game.getFood())) {
                    System.out.print("@ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
