package com.github.javadojo.movement;

public class MovingVector {

    private final int x;
    private final int y;

    public MovingVector(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public MovingVector multiplyByMatrix(RotationMatrix rotationMatrix) {
        int firstLine = rotationMatrix.getValues()[0][0] * this.x + rotationMatrix.getValues()[0][1] * this.y;
        int secondLine = rotationMatrix.getValues()[1][0] * this.x + rotationMatrix.getValues()[1][1] * this.y;
        return new MovingVector(firstLine, secondLine);
    }

    public boolean isHorizontal() {
        return this.y == 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
