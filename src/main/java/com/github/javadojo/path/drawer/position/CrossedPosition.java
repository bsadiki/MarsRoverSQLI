package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.*;

public class CrossedPosition extends DrawerPosition {
    public CrossedPosition() {
        super(2);
    }

    @Override
    public String draw(String newContent) {
        if (newContent.equals(SAMPLE)
                || newContent.equals(START_POINT)
                || newContent.equals(CURRENT_POSITION))
            return newContent;
        return DOUBLE_CROSSED_PATH;
    }
}
