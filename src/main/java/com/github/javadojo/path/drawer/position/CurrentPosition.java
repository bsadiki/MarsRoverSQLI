package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.CURRENT_POSITION;

public class CurrentPosition extends DrawerPosition {
    private static CurrentPosition ourInstance = new CurrentPosition();

    public static CurrentPosition getInstance() {
        return ourInstance;
    }

    private CurrentPosition() {
        super(10);
    }

    @Override
    public String draw() {
        return CURRENT_POSITION;
    }
}
