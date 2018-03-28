package com.github.javadojo.path.drawer;

import static com.github.javadojo.MarsRover.LINE_SEPARATOR;

public class MatrixDrawer {

    String drawMatrix(String[][] drawableMatrix) {
        StringBuilder drawBuilder = new StringBuilder();
        for (String[] drawableLine : drawableMatrix) {
            for (String drawablePoint : drawableLine)
                drawBuilder.append(drawablePoint);
            drawBuilder.append(LINE_SEPARATOR);
        }
        return drawBuilder.toString();
    }
}