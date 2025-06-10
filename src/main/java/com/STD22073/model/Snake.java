package com.STD22073.model;

import java.util.*;

public class Snake {
    private final List<Point> body;
    private Direction direction;
    private boolean shouldGrow;

    public Snake(List<Point> initialBody, Direction initialDirection) {
        this.body = new ArrayList<>(initialBody);
        this.direction = initialDirection;
        this.shouldGrow = false;
    }

    public void move() {
        Point head = getHead();
        Point newHead = head.add(direction.getDelta());
        body.add(0, newHead);

        if (!shouldGrow) {
            body.remove(body.size() - 1);
        } else {
            shouldGrow = false;
        }
    }

    public void grow() {
        shouldGrow = true;
    }

    public void changeDirection(Direction newDirection) {
        if (newDirection != direction.getOpposite()) {
            direction = newDirection;
        }
    }

    public Point getHead() {
        return body.get(0);
    }

    public List<Point> getBody() {
        return Collections.unmodifiableList(body);
    }

    public boolean isCollidingWithItself() {
        Point head = getHead();
        return body.subList(1, body.size()).contains(head);
    }

    public boolean isCollidingWithWalls(int gridWidth, int gridHeight) {
        Point head = getHead();
        return head.getX() < 0 || head.getX() >= gridWidth ||
                head.getY() < 0 || head.getY() >= gridHeight;
    }

    public boolean isEatingFood(Point food) {
        return getHead().equals(food);
    }

    public int getLength() {
        return body.size();
    }

    public Direction getDirection() {
        return direction;
    }
}