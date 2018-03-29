package com.github.javadojo.path.drawer.position;

public class EmptyPosition extends DrawerPosition {
    protected EmptyPosition() {
        super(0);
    }

    @Override
    public String draw(String newContent) {
        return newContent;
    }
}
