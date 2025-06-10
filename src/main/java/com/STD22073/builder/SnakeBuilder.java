package com.STD22073.builder;

import com.STD22073.model.Direction;
import com.STD22073.model.Point;
import com.STD22073.model.Snake;

import java.util.*;

public class SnakeBuilder {
    private List<Point> body = new ArrayList<>();
    private Direction direction = Direction.RIGHT;

    public SnakeBuilder withStartPosition(int x, int y) {
        body.clear();
        body.add(new Point(x, y));
        return this;
    }

    public SnakeBuilder withLength(int length) {
        if (body.isEmpty()) {
            throw new IllegalStateException("Start position must be set before length");
        }

        Point head = body.get(0);
        Point delta = direction.getOpposite().getDelta();

        for (int i = 1; i < length; i++) {
            Point nextSegment = head.add(new Point(delta.getX() * i, delta.getY() * i));
            body.add(nextSegment);
        }

        return this;
    }

    public SnakeBuilder withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Snake build() {
        if (body.isEmpty()) {
            throw new IllegalStateException("Snake must have at least one segment");
        }

        return new Snake(body, direction);
    }
}
