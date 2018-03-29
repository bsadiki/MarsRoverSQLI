package com.github.javadojo.path.drawer.position;

public abstract class DrawerPosition {
    protected final int priority ;

    protected DrawerPosition(int priority) {
        this.priority = priority;
    }

    public DrawerPosition overridePosition(DrawerPosition newDrawerPosition){
        if (this.priority<newDrawerPosition.priority)
            return newDrawerPosition;
        else return this;
    }

    public abstract String draw();
}
