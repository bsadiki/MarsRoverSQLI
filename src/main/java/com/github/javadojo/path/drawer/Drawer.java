package com.github.javadojo.path.drawer;

import com.github.javadojo.path.PathPosition;
import com.github.javadojo.path.drawer.position.DrawerPosition;
import com.github.javadojo.path.drawer.position.DrawerPositionFactory;
import com.github.javadojo.position.PositionSorter;

import java.util.Arrays;
import java.util.List;

import static com.github.javadojo.config.Configuration.*;

public class Drawer {

    private final PositionSorter positionSorter;
    private String[][] drawingMatrix;
    private final MatrixDrawer matrixDrawer;
    private final DrawerPositionFactory drawerPositionFactory;

    public Drawer(PositionSorter positionSorter, MatrixDrawer matrixDrawer, DrawerPositionFactory drawerPositionFactory) {
        this.positionSorter = positionSorter;
        this.matrixDrawer = matrixDrawer;
        this.drawerPositionFactory = drawerPositionFactory;
    }

    public String draw(List<PathPosition> drawingPathPosition) {
        initializeMatrix(drawingPathPosition);
        fillMatrix(drawingPathPosition);
        return matrixDrawer.drawMatrix(drawingMatrix);
    }

    private void initializeMatrix(List<PathPosition> drawingPathPosition) {
        int[] drawingMatrixDimension = positionSorter.firstAndLastPosition(drawingPathPosition)[0].distanceFromOtherPosition(positionSorter.firstAndLastPosition(drawingPathPosition)[1]);
        drawingMatrix = new String[drawingMatrixDimension[0]][drawingMatrixDimension[1]];
        for (String[] row : drawingMatrix) {
            Arrays.fill(row, EMPTY_POSITION);
        }
    }

    private void fillMatrix(List<PathPosition> drawingPathPosition) {
        addIntermediatePosition(drawingPathPosition);
    }

    private void addIntermediatePosition(List<PathPosition> drawingPathPosition) {
        for (PathPosition pathPosition : drawingPathPosition) {
            DrawerPosition currentDrawerPosition = drawerPositionFactory.createDrawerPosition(drawingMatrix[pathPosition.getX()][pathPosition.getY()]);
            DrawerPosition newDrawerPosition = drawerPositionFactory.createDrawerPosition(pathPosition.draw(drawingPathPosition.indexOf(pathPosition), drawingPathPosition.size()));
            DrawerPosition overrideDrawerPosition = currentDrawerPosition.overridePosition(newDrawerPosition);
            drawingMatrix[pathPosition.getX()][pathPosition.getY()] = overrideDrawerPosition.draw();
        }
    }


}
