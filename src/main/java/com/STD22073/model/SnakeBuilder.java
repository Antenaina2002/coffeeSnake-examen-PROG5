package com.STD22073.model;

import java.util.*;

public class SnakeBuilder {
    private List<Point> initialBody;
    private Direction initialDirection;

    public SnakeBuilder setInitialBody(List<Point> body) {
        this.initialBody = body;
        return this;
    }

    public SnakeBuilder setInitialDirection(Direction direction) {
        this.initialDirection = direction;
        return this;
    }

    public Snake build() {
        return new Snake(initialBody, initialDirection);
    }
}
