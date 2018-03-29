package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.DOUBLE_CROSSED_PATH;
import static com.github.javadojo.config.Configuration.HORIZONTAL_PATH;
import static com.github.javadojo.config.Configuration.VERTICAL_PATH;

public class VerticalPosition extends NormalPosition {
    @Override
    public String linePosition(String newContent) {
        if (newContent.equals(HORIZONTAL_PATH))
            return DOUBLE_CROSSED_PATH;
        else return VERTICAL_PATH;
    }
}
