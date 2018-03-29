package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.CURRENT_POSITION;

public class CurrentPosition extends DrawerPosition {
    protected CurrentPosition() {
        super(10);    }

    @Override
    public String draw(String newContent) {
        return CURRENT_POSITION;
    }
}
