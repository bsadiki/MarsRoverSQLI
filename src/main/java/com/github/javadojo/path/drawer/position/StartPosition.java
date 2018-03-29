package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.START_POINT;

public class StartPosition extends DrawerPosition {
    private static StartPosition ourInstance = new StartPosition();

    public static StartPosition getInstance() {
        return ourInstance;
    }
    private StartPosition() {
        super(8);
    }

    @Override
    public String draw() {
        return START_POINT;
    }
}
