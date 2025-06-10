package com.STD22073.model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FoodFactory {
    public Point generateFood(Snake snake, int gridSize) {
        List<Point> availablePoints = new ArrayList<>();
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                Point p = new Point(x, y);
                if (!snake.contains(p)) {
                    availablePoints.add(p);
                }
            }
        }
        if (availablePoints.isEmpty()) return null;
        return availablePoints.get(ThreadLocalRandom.current().nextInt(availablePoints.size()));
    }
}