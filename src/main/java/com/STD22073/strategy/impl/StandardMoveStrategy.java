package com.STD22073.strategy.impl;

import com.STD22073.model.Direction;
import com.STD22073.model.Point;
import com.STD22073.model.Snake;
import com.STD22073.strategy.MoveStrategy;

public class StandardMoveStrategy implements MoveStrategy {
    @Override
    public Point computeNextPosition(Snake snake, Direction direction) {
        return snake.getHead().add(direction.getDelta());
    }
}
