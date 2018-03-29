package com.github.javadojo.path.drawer.position;

public abstract class NormalPosition extends DrawerPosition {
    protected NormalPosition() {
        super(1);
    }

    @Override
    public DrawerPosition overridePosition(DrawerPosition newDrawerPosition) {
        if (this.priority < newDrawerPosition.priority)
            return newDrawerPosition;
        else if (this.priority == newDrawerPosition.priority)
            return this.linePosition(newDrawerPosition);
        else return this;
    }

    public DrawerPosition linePosition(DrawerPosition newDrawerPosition) {
        if (newDrawerPosition.equals(this))
            return this;
        else return CrossedPosition.getInstance();
    }
}
