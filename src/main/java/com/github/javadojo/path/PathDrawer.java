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
        String[][] drawingMatrix = initializeMatrix(drawingPathPosition);
        Position origin = getOrigin(drawingPathPosition);
        addIntermediatePosition(drawingMatrix, origin, drawingPathPosition);
        addStartPoint(drawingMatrix, origin, drawingPathPosition);
        addCurrentPosition(drawingMatrix, origin, drawingPathPosition);
        return drawMatrix(drawingMatrix);
    }

    private List<PathPosition> convertToDrawing(List<PathPosition> pathPositions) {
        List<PathPosition> drawingPathPositions = reverse(pathPositions);

        return drawingPathPositions;
    }

    private List<PathPosition> reverse(List<PathPosition> drawingPathPosition) {
        List<PathPosition> reversedPathPosition = new ArrayList<>();
        drawingPathPosition.forEach(pathPosition -> {
            reversedPathPosition.add(pathPosition.reverse()) ;
        });
        return reversedPathPosition;
    }

    private String[][] initializeMatrix(List<PathPosition> drawingPathPosition) {
        int[] drawingMatrixDimension = firstAndLastPosition(drawingPathPosition)[0].distanceFromOtherPosition(firstAndLastPosition(drawingPathPosition)[1]);
        String[][] drawingMatrix = new String[drawingMatrixDimension[0]][drawingMatrixDimension[1]];
        for (int i = 0; i < drawingMatrix.length; i++) {
            for (int j = 0; j < drawingMatrix[i].length; j++) {
                drawingMatrix[i][j] = " ";
            }
        }
        return drawingMatrix;
    }

    private Position getOrigin(List<PathPosition> drawingPathPosition) {
        return new Position(firstAndLastPosition(drawingPathPosition)[0]);
    }

    private Position[] firstAndLastPosition(List<PathPosition> drawingPathPosition) {
        ArrayList<PathPosition> comparingList = new ArrayList<>(drawingPathPosition);
        comparingList.sort(new WidthComparator());
        int minX = comparingList.get(0).x();
        int maxX = comparingList.get(comparingList.size() - 1).x();
        comparingList.sort(new HeightComparator());
        int minY = comparingList.get(0).y();
        int maxY = comparingList.get(comparingList.size() - 1).y();
        return new Position[]{new Position(maxX, minY), new Position(minX, maxY)};
    }

    private void addIntermediatePosition(String[][] drawingMatrix, Position origin, List<PathPosition> drawingPathPosition) {
        for (int i = 1; i < drawingPathPosition.size() - 1; i++) {
            PathPosition pathPosition = drawingPathPosition.get(i);
            int x = -(pathPosition.x() - origin.getX());
            int y = pathPosition.y() - origin.getY();
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

    private void addStartPoint(String[][] drawingMatrix, Position origin, List<PathPosition> drawingPathPosition) {
        int xFirstPosition = -(drawingPathPosition.get(0).x() - origin.getX());
        int yFirstPosition = drawingPathPosition.get(0).y() - origin.getY();
        drawingMatrix[xFirstPosition][yFirstPosition] = "X";
    }

    private void addCurrentPosition(String[][] drawingMatrix, Position origin, List<PathPosition> drawingPathPosition) {
        int xCurrentPosition = drawingPathPosition.get(drawingPathPosition.size() - 1).x() - origin.getX();
        int yCurrentPosition = drawingPathPosition.get(drawingPathPosition.size() - 1).y() - origin.getY();
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
