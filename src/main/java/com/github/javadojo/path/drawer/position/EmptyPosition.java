package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.EMPTY_POSITION;

public class EmptyPosition extends DrawerPosition {
    private static EmptyPosition ourInstance = new EmptyPosition();

    public static EmptyPosition getInstance() {
        return ourInstance;
    }
    private EmptyPosition() {
        super(0);
    }

    @Override
    public String draw() {
        return EMPTY_POSITION;
    }
}
