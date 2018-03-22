package com.github.javadojo.movement;

public enum RotationMatrix {
    TURN_RIGHT(0,1,-1,0),
    TURN_LEFT(0,-1,1,0)
    ;
    private int[][] values;

    RotationMatrix(int v11, int v12, int v21, int v22) {
        this.values = new int[][]{{v11,v12},{v21,v22}};
    }

    public int[][] getValues() {
        return values;
    }
}
