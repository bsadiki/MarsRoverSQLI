package com.github.javadojo;

public class PathPosition implements Drawable {
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

    private boolean isSample() {
        return sample;
    }

    public void makeSample() {
        this.sample = true;
    }

    public boolean hasChangedDirection() {
        return changedDirection;
    }

    public void changeDirection() {
        this.changedDirection = true;

    }

    public int x() {
        return this.position.x();
    }

    public int y() {
        return this.position.y();
    }


    @Override
    public String draw() {
        if (isSample())
            return "S";
        if (hasChangedDirection())
            return "+";
        if (isHorizontal())
            return "-";
        return "|";
    }

    private Boolean isHorizontal() {
        return this.movingVector.isHorizontal();
    }
}
