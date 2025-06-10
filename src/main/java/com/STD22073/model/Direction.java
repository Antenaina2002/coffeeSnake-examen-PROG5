package com.STD22073.model;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final Point delta;

    Direction(int deltaX, int deltaY) {
        this.delta = new Point(deltaX, deltaY);
    }

    public Point getDelta() {
        return delta;
    }

    public Direction getOpposite() {
        switch (this) {
            case UP: return DOWN;
            case DOWN: return UP;
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            default: return this;
        }
    }
}