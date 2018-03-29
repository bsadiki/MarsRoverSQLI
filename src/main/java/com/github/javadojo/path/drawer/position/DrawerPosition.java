package com.github.javadojo.path.drawer.position;

public abstract class DrawerPosition {
    protected final int priority ;

    protected DrawerPosition(int priority) {
        this.priority = priority;
    }

    public abstract String draw(String newContent);
}
