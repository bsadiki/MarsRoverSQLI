package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.*;

public class CrossedPosition extends DrawerPosition {
    private static CrossedPosition ourInstance = new CrossedPosition();

    public static CrossedPosition getInstance() {
        return ourInstance;
    }

    private CrossedPosition() {
        super(2);
    }

    @Override
    public String draw() {
        return DOUBLE_CROSSED_PATH;
    }
}
