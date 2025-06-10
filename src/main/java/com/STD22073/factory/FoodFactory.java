package com.STD22073.factory;

import com.STD22073.model.Point;

import java.util.*;

public class FoodFactory {
    private final Random random;
    private final int gridWidth;
    private final int gridHeight;

    public FoodFactory(int gridWidth, int gridHeight) {
        this.random = new Random();
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public Point generateFood(List<Point> occupiedPositions) {
        List<Point> availablePositions = getAllAvailablePositions(occupiedPositions);

        if (availablePositions.isEmpty()) {
            throw new IllegalStateException("No available positions for food");
        }

        int randomIndex = random.nextInt(availablePositions.size());
        return availablePositions.get(randomIndex);
    }

    private List<Point> getAllAvailablePositions(List<Point> occupiedPositions) {
        List<Point> available = new ArrayList<>();
        Set<Point> occupied = new HashSet<>(occupiedPositions);

        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                Point position = new Point(x, y);
                if (!occupied.contains(position)) {
                    available.add(position);
                }
            }
        }

        return available;
    }
}