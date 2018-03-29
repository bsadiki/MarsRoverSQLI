package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.*;

public abstract class NormalPosition extends DrawerPosition {
    protected NormalPosition() {
        super(1);
    }

    @Override
    public String draw(String newContent) {
        if (newContent.equals(SAMPLE)
                || newContent.equals(START_POINT)
                || newContent.equals(CURRENT_POSITION)
                || newContent.equals(DOUBLE_CROSSED_PATH))
            return newContent;
        else return this.linePosition(newContent);
    }
    public abstract String linePosition(String newContent);
}
