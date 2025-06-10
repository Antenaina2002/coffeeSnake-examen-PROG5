package com.STD22073.strategy;

import com.STD22073.model.Direction;
import com.STD22073.model.Snake;

public interface MoveStrategy {
    Direction computeNextDirection(Snake snake, Direction currentDirection);
}
