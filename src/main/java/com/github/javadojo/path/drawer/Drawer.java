package com.github.javadojo.path.drawer;

import com.github.javadojo.path.PathPosition;
import com.github.javadojo.position.PositionSorter;

import java.util.List;

public class Drawer {
    private static final String SAMPLE = "S";
    private static final String START_POINT = "X";
    private static final String CURRENT_POSITION = "*";
    private static final String HORIZONTAL_PATH = "-";
    private static final String VERTICAL_PATH = "|";
    private static final String DOUBLE_CROSSED_PATH = "+";
    private final PositionSorter positionSorter;
    private String[][] drawingMatrix;
    private final MatrixDrawer matrixDrawer;

    public Drawer(PositionSorter positionSorter, MatrixDrawer matrixDrawer) {
        this.positionSorter = positionSorter;
        this.matrixDrawer = matrixDrawer;
    }

    public String draw(List<PathPosition> drawingPathPosition) {
        initializeMatrix(drawingPathPosition);
        fillMatrix(drawingPathPosition);
        return matrixDrawer.drawMatrix(drawingMatrix);
    }

    private void initializeMatrix(List<PathPosition> drawingPathPosition) {
        int[] drawingMatrixDimension = positionSorter.firstAndLastPosition(drawingPathPosition)[0].distanceFromOtherPosition(positionSorter.firstAndLastPosition(drawingPathPosition)[1]);
        drawingMatrix = new String[drawingMatrixDimension[0]][drawingMatrixDimension[1]];
        for (int i = 0; i < drawingMatrix.length; i++) {
            for (int j = 0; j < drawingMatrix[i].length; j++) {
                drawingMatrix[i][j] = " ";
            }
        }
    }

    private void fillMatrix(List<PathPosition> drawingPathPosition) {
        addIntermediatePosition(drawingPathPosition);
        addStartPoint(drawingPathPosition);
        addCurrentPosition(drawingPathPosition);
    }

    private void addIntermediatePosition(List<PathPosition> drawingPathPosition) {
        for (int i = 1; i < drawingPathPosition.size() - 1; i++) {
            PathPosition pathPosition = drawingPathPosition.get(i);
            if (!drawingMatrix[pathPosition.x()][pathPosition.y()].equals(SAMPLE)) {
                if (pathPosition.draw().equals(SAMPLE))
                    drawingMatrix[pathPosition.x()][pathPosition.y()] = pathPosition.draw();
                else {
                    if (drawingMatrix[pathPosition.x()][pathPosition.y()].equals(HORIZONTAL_PATH) ||
                            drawingMatrix[pathPosition.x()][pathPosition.y()].equals(VERTICAL_PATH))
                        drawingMatrix[pathPosition.x()][pathPosition.y()] = DOUBLE_CROSSED_PATH;
                    else {
                        drawingMatrix[pathPosition.x()][pathPosition.y()] = pathPosition.draw();
                    }
                }
            }
        }
    }

    private void addStartPoint(List<PathPosition> drawingPathPosition) {
        drawingMatrix[drawingPathPosition.get(0).x()][drawingPathPosition.get(0).y()] = START_POINT;
    }

    private void addCurrentPosition(List<PathPosition> drawingPathPosition) {
        drawingMatrix[drawingPathPosition.get(drawingPathPosition.size() - 1).x()][drawingPathPosition.get(drawingPathPosition.size() - 1).y()] = CURRENT_POSITION;
    }

}
