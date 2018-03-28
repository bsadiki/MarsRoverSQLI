package com.github.javadojo.path;

import com.github.javadojo.Drawable;
import com.github.javadojo.movement.MovingVector;
import com.github.javadojo.position.Position;

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

    public boolean hasChangedDirection() {
        return changedDirection;
    }

    public void changeDirection() {
        this.changedDirection = true;
    }

    public int x() {
        return this.position.getX();
    }

    public int y() {
        return this.position.getY();
    }
    public PathPosition reverse(){
        return new PathPosition(this.position.reverse(),this.movingVector,this.sample,this.changedDirection);
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
