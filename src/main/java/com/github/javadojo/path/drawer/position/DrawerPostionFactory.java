package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.*;

public class DrawerPostionFactory {

    public DrawerPosition createDrawerPosition(String drawerPosition) {
        switch (drawerPosition) {
            case EMPTY_POSITION:
                return new EmptyPosition();
            case SAMPLE:
                return new SamplePosition();
            case CURRENT_POSITION:
                return new CurrentPosition();
            case START_POINT:
                return new StartPosition();
            case DOUBLE_CROSSED_PATH:
                return new CrossedPosition();
            case HORIZONTAL_PATH:
                return new HorizontalPosition();
            case VERTICAL_PATH:
                return new VerticalPosition();
            default:
                return new EmptyPosition();
        }
    }

    public DrawerPosition createDrawerPosition() {
        return new EmptyPosition();
    }

}
