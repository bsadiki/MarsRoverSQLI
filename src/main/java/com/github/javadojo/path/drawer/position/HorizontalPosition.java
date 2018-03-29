package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.HORIZONTAL_PATH;

public class HorizontalPosition extends NormalPosition {
    private static HorizontalPosition ourInstance = new HorizontalPosition();

    public static HorizontalPosition getInstance() {
        return ourInstance;
    }

    @Override
    public String draw() {
        return HORIZONTAL_PATH;
    }
}
