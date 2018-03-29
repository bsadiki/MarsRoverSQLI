package com.github.javadojo.path;

import com.github.javadojo.Drawable;
import com.github.javadojo.movement.MovingVector;
import com.github.javadojo.path.drawer.Drawer;
import com.github.javadojo.position.Position;

import java.util.List;

public class Path implements Drawable {
    private final List<PathPosition> pathPositions;
    private final PathListConverter pathListConverter;
    private final Drawer drawer;
    public Path(List<PathPosition> pathPositions, Drawer drawer, PathListConverter pathListConverter) {
        this.pathPositions = pathPositions;
        this.drawer = drawer;
        this.pathListConverter = pathListConverter;
    }

    public void addPosition(Position position, MovingVector movingVector) {
        this.pathPositions.add(new PathPosition(new Position(position), movingVector));
    }

    public void addSamplePosition() {
        this.pathPositions.get(this.pathPositions.size() - 1).makeSample();
    }

    public void changeDirection() {
        this.pathPositions.get(this.pathPositions.size() - 1).changeDirection();
    }

    @Override
    public String draw() {
        List<PathPosition> drawablePathPosition = pathListConverter.convertToDrawable(pathPositions);
        return this.drawer.draw(drawablePathPosition);
    }
}
