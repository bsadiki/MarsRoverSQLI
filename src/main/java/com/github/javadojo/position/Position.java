package com.github.javadojo.position;

import com.github.javadojo.movement.MovingVector;

public class Position {
    private final int[] values;

    public Position(int x, int y) {
        this.values = new int[]{x,y};
    }

    public Position(Position position) {
        this.values = new int[]{position.values[1],position.values[0]};
    }

    public void move(MovingVector movingVector){
        this.values[0] += movingVector.getVector()[0];
        this.values[1] += movingVector.getVector()[1];
    }

    @Override
    public String toString() {
        return this.values[0] + "," + this.values[1];
    }
    public int [] distanceFromOtherPosition(Position position){
        int hDiff = this.values[0] - position.values[0] ;
        int vDiff = this.values[1] - position.values[1] ;
        return new int[]{Math.abs(hDiff)+1,Math.abs(vDiff)+1};
    }
    public int x(){
        return values[0];
    }
    public int y(){
        return values[1];
    }
}
