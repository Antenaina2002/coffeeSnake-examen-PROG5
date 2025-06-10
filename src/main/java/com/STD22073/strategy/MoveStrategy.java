package com.STD22073.strategy;

import com.STD22073.model.Direction;
import com.STD22073.model.Point;
import com.STD22073.model.Snake;

public interface MoveStrategy {
    Point computeNextPosition(Snake snake, Direction direction);
}
