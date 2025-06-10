package com.STD22073.model;

import java.util.*;

public class Snake {
    private List<Point> body;
    private Direction direction;
    private boolean growNextMove = false;

    public Snake(List<Point> body, Direction direction) {
        this.body = new ArrayList<>(body);
        this.direction = direction;
    }

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.UP && direction == Direction.DOWN) ||
                (this.direction == Direction.DOWN && direction == Direction.UP) ||
                (this.direction == Direction.LEFT && direction == Direction.RIGHT) ||
                (this.direction == Direction.RIGHT && direction == Direction.LEFT)) {
            return;
        }
        this.direction = direction;
    }

    public void move() {
        Point head = getHead();
        Point newHead = switch (direction) {
            case UP -> new Point(head.getX(), head.getY() - 1);
            case DOWN -> new Point(head.getX(), head.getY() + 1);
            case LEFT -> new Point(head.getX() - 1, head.getY());
            case RIGHT -> new Point(head.getX() + 1, head.getY());
        };

        body.add(0, newHead);
        if (!growNextMove) {
            body.remove(body.size() - 1);
        } else {
            growNextMove = false;
        }
    }

    public void grow() {
        growNextMove = true;
    }

    public Point getHead() {
        return body.get(0);
    }

    public List<Point> getBody() {
        return new ArrayList<>(body);
    }

    public boolean contains(Point point) {
        return body.contains(point);
    }
}