package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.CURRENT_POSITION;
import static com.github.javadojo.config.Configuration.SAMPLE;
import static com.github.javadojo.config.Configuration.START_POINT;

public class SamplePosition extends DrawerPosition {
    protected SamplePosition() {
        super(5);
    }

    @Override
    public String draw(String newContent) {
        if(newContent.equals(START_POINT)||newContent.equals(CURRENT_POSITION))
            return newContent;
        return SAMPLE;
    }
}
