package com.github.javadojo.path;

import com.github.javadojo.movement.MovingVector;
import com.github.javadojo.position.Position;

import static com.github.javadojo.config.Configuration.*;

public class PathPosition {
    private final Position position;
    private final MovingVector movingVector;
    private boolean sample;
    private boolean changedDirection;

    public PathPosition(Position position, MovingVector movingVector) {
        this.position = position;
        this.movingVector = movingVector;
        this.sample = false;
        this.changedDirection = false;
    }

    private PathPosition(Position position, MovingVector movingVector, boolean sample, boolean changedDirection) {
        this.position = position;
        this.movingVector = movingVector;
        this.sample = sample;
        this.changedDirection = changedDirection;
    }

    private boolean isSample() {
        return sample;
    }

    public void makeSample() {
        this.sample = true;
    }

    private boolean hasChangedDirection() {
        return changedDirection;
    }

    public void changeDirection() {
        this.changedDirection = true;
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public PathPosition reverse() {
        return new PathPosition(this.position.reverse(), this.movingVector, this.sample, this.changedDirection);
    }

    public String draw(int index, int listSize) {
        if (index == 0)
            return START_POINT;
        if (index == listSize - 1)
            return CURRENT_POSITION;
        if (isSample())
            return SAMPLE;
        if (hasChangedDirection())
            return DOUBLE_CROSSED_PATH;
        if (isHorizontal())
            return HORIZONTAL_PATH;
        return VERTICAL_PATH;
    }

    private Boolean isHorizontal() {
        return this.movingVector.isHorizontal();
    }

    public void adjustToOrigin(Position origin) {
        this.position.adjustToOrigin(origin);
    }
}
