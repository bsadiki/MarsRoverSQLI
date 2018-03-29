package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.CURRENT_POSITION;
import static com.github.javadojo.config.Configuration.START_POINT;

public class StartPosition extends DrawerPosition {
    protected StartPosition() {
        super(8);
    }

    @Override
    public String draw(String newContent) {
        if(newContent.equals(CURRENT_POSITION))
            return newContent;
        return START_POINT;
    }
}
