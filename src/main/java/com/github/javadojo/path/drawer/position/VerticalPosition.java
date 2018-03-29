package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.*;

public class VerticalPosition extends NormalPosition {
    private static VerticalPosition ourInstance = new VerticalPosition();

    public static VerticalPosition getInstance() {
        return ourInstance;
    }


    @Override
    public String draw() {
        return VERTICAL_PATH;
    }
}
