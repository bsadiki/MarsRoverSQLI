package com.github.javadojo.path;

import com.github.javadojo.Drawable;
import com.github.javadojo.movement.MovingVector;
import com.github.javadojo.position.Position;

import java.util.ArrayList;
import java.util.List;

public class Path implements Drawable {
    private final List<PathPosition> pathPositions;
    private final PathDrawer pathDrawer;

    public Path() {
        this.pathPositions = new ArrayList<>();
        this.pathDrawer = new PathDrawer();
    }

    public void addPosition(Position position, MovingVector movingVector) {
        this.pathPositions.add(new PathPosition(position.reverse(), movingVector));
    }

    public void addSamplePosition() {
        this.pathPositions.get(this.pathPositions.size() - 1).makeSample();
    }

    public void changeDirection() {
        this.pathPositions.get(this.pathPositions.size() - 1).changeDirection();
    }

    @Override
    public String draw() {
        return this.pathDrawer.draw(this.pathPositions);
    }
}
