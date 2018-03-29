package com.github.javadojo.path.drawer.position;

import static com.github.javadojo.config.Configuration.*;

public class DrawerPositionFactory {

    public DrawerPosition createDrawerPosition(String drawerPosition) {
        switch (drawerPosition) {
            case EMPTY_POSITION:
                return EmptyPosition.getInstance();
            case SAMPLE:
                return SamplePosition.getInstance();
            case CURRENT_POSITION:
                return CurrentPosition.getInstance();
            case START_POINT:
                return StartPosition.getInstance();
            case DOUBLE_CROSSED_PATH:
                return CrossedPosition.getInstance();
            case HORIZONTAL_PATH:
                return HorizontalPosition.getInstance();
            case VERTICAL_PATH:
                return VerticalPosition.getInstance();
            default:
                return EmptyPosition.getInstance();
        }
    }
}
