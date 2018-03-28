package com.github.javadojo.position;

import com.github.javadojo.movement.MovingVector;

public class Position {
    private final RectangularCoordinate coordinates;

    public Position(int x, int y) {
        this.coordinates = new RectangularCoordinate(x,y);
    }

    public Position(Position position) {
        this.coordinates = new RectangularCoordinate(position.coordinates.y,position.coordinates.x);
    }

    public void move(MovingVector movingVector){
        this.coordinates.x += movingVector.getVector()[0];
        this.coordinates.y += movingVector.getVector()[1];
    }

    @Override
    public String toString() {
        return this.coordinates.x + "," + this.coordinates.y;
    }
    public int [] distanceFromOtherPosition(Position position){
        int hDiff = this.coordinates.x - position.coordinates.x;
        int vDiff = this.coordinates.y - position.coordinates.y ;
        return new int[]{Math.abs(hDiff)+1,Math.abs(vDiff)+1};
    }
    public int getX(){
        return coordinates.x;
    }
    public int getY(){
        return coordinates.y;
    }
}
