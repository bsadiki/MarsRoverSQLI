package com.github.javadojo.movement;

public class MovingVector {

    private final int[] vector;

    public MovingVector(int value1, int value2) {
        this.vector = new int[]{value1, value2};
    }

    public int[] getVector() {
        return vector;
    }

    public MovingVector multiplyByMatrix(RotationMatrix rotationMatrix) {
        int firstLine = rotationMatrix.getValues()[0][0] * this.vector[0] + rotationMatrix.getValues()[0][1] * this.vector[1];
        int secondLine = rotationMatrix.getValues()[1][0] * this.vector[0] + rotationMatrix.getValues()[1][1] * this.vector[1];
        return new MovingVector(firstLine, secondLine);
    }

    public boolean isHorizontal() {
        return this.vector[1] == 0;
    }
}
