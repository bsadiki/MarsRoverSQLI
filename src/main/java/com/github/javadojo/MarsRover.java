package com.github.javadojo;

public class MarsRover {

    public static final String LINE_SEPARATOR = "\n";
    private Position currentPosition;
    private MovingVector movingVector;
    private final Path path;

    public MarsRover(String s) {
        this.currentPosition = new Position(0, 0);
        this.movingVector = new MovingVector(1, 0);
        this.path = new Path();
        addPositionToPath();
        MovingParser.parse(s, this);
    }

    public String path() {
        return this.path.draw();
    }

    public MarsRover turnLeft() {
        this.movingVector = this.movingVector.multiplyByMatrix(RotationMatrix.TURN_LEFT);
        this.path.changeDirection();
        return this;
    }

    public MarsRover turnRight() {
        this.movingVector = this.movingVector.multiplyByMatrix(RotationMatrix.TURN_RIGHT);
        this.path.changeDirection();
        return this;
    }

    public MarsRover moveForward() {
        this.currentPosition.move(movingVector);
        addPositionToPath();
        return this;
    }

    public void addSamplePositionToPath() {
        this.path.makeSamplePosition();
    }

    private void addPositionToPath() {
        this.path.addPosition(this.currentPosition, this.movingVector);
    }
}
