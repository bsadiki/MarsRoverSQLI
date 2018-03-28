package com.github.javadojo.path;

import com.github.javadojo.position.HeightComparator;
import com.github.javadojo.position.Position;
import com.github.javadojo.position.WidthComparator;

import java.util.ArrayList;
import java.util.List;

import static com.github.javadojo.MarsRover.LINE_SEPARATOR;

public class PathDrawer {
    String draw(List<PathPosition> pathPositions) {
        List<PathPosition> drawingPathPosition = convertToDrawing(pathPositions);
        String[][] drawingMatrix = initializeMatrix(pathPositions);
        int[] origin = getOrigin(pathPositions);
        addIntermediatePosition(drawingMatrix, origin, pathPositions);
        addStartPoint(drawingMatrix, origin, pathPositions);
        addCurrentPosition(drawingMatrix, origin, pathPositions);
        return drawMatrix(drawingMatrix);
    }

    private List<PathPosition> convertToDrawing(List<PathPosition> pathPositions) {
        List<PathPosition> drawingPathPosition = new ArrayList<>();
        pathPositions.forEach(pathPosition -> {
            drawingPathPosition.add(pathPosition.reverse()) ;
        });
        return drawingPathPosition;
    }

    private String[][] initializeMatrix(List<PathPosition> pathPositions) {
        int[] drawingMatrixDimension = firstAndLastPosition(pathPositions)[0].distanceFromOtherPosition(firstAndLastPosition(pathPositions)[1]);
        String[][] drawingMatrix = new String[drawingMatrixDimension[0]][drawingMatrixDimension[1]];
        for (int i = 0; i < drawingMatrix.length; i++) {
            for (int j = 0; j < drawingMatrix[i].length; j++) {
                drawingMatrix[i][j] = " ";
            }
        }
        return drawingMatrix;
    }

    private int[] getOrigin(List<PathPosition> pathPositions) {
        return new int[]{firstAndLastPosition(pathPositions)[0].getX(), firstAndLastPosition(pathPositions)[0].getY()};
    }

    private Position[] firstAndLastPosition(List<PathPosition> pathPositions) {
        ArrayList<PathPosition> comparingList = new ArrayList<>(pathPositions);
        comparingList.sort(new WidthComparator());
        int minX = comparingList.get(0).x();
        int maxX = comparingList.get(comparingList.size() - 1).x();
        comparingList.sort(new HeightComparator());
        int minY = comparingList.get(0).y();
        int maxY = comparingList.get(comparingList.size() - 1).y();
        return new Position[]{new Position(maxX, minY), new Position(minX, maxY)};
    }

    private void addIntermediatePosition(String[][] drawingMatrix, int[] origin, List<PathPosition> pathPositions) {
        for (int i = 1; i < pathPositions.size() - 1; i++) {
            PathPosition pathPosition = pathPositions.get(i);
            int x = -(pathPosition.x() - origin[0]);
            int y = pathPosition.y() - origin[1];
            if (pathPosition.draw().equals("S"))
                drawingMatrix[x][y] = pathPosition.draw();
            else {
                if (drawingMatrix[x][y].equals("-") ||
                        drawingMatrix[x][y].equals("|"))
                    drawingMatrix[x][y] = "+";
                else if (!drawingMatrix[x][y].equals("S") &&
                        !drawingMatrix[x][y].equals("X")) {
                    drawingMatrix[x][y] = pathPosition.draw();
                }
            }
        }
    }

    private void addStartPoint(String[][] drawingMatrix, int[] origin, List<PathPosition> pathPositions) {
        int xFirstPosition = -(pathPositions.get(0).x() - origin[0]);
        int yFirstPosition = pathPositions.get(0).y() - origin[1];
        drawingMatrix[xFirstPosition][yFirstPosition] = "X";
    }

    private void addCurrentPosition(String[][] drawingMatrix, int[] origin, List<PathPosition> pathPositions) {
        int xCurrentPosition = pathPositions.get(pathPositions.size() - 1).x() - origin[0];
        int yCurrentPosition = pathPositions.get(pathPositions.size() - 1).y() - origin[1];
        drawingMatrix[-xCurrentPosition][yCurrentPosition] = "*";
    }

    private String drawMatrix(String[][] drawingMatrix) {
        StringBuilder drawBuilder = new StringBuilder();
        for (int i = 0; i < drawingMatrix.length; i++) {
            for (int j = 0; j < drawingMatrix[i].length; j++) {
                drawBuilder.append(drawingMatrix[i][j]);
            }
            drawBuilder.append(LINE_SEPARATOR);
        }
        return drawBuilder.toString();
    }
}
