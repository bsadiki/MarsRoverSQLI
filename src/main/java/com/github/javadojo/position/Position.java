package com.github.javadojo.position;

import com.github.javadojo.movement.MovingVector;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(MovingVector movingVector) {
        this.x += movingVector.getX();
        this.y += movingVector.getY();
    }

    public int[] distanceFromOtherPosition(Position position) {
        int hDiff = this.x - position.x;
        int vDiff = this.y - position.y;
        return new int[]{Math.abs(hDiff) + 1, Math.abs(vDiff) + 1};
    }

    public Position reverse(){
        return new Position(this.y,this.x);
    }

    public void adjustToOrigin(Position origin) {
         x = -(x - origin.x);
         y = y - origin.y;
    }
}
