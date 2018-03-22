package com.github.javadojo.path;

import com.github.javadojo.Drawable;
import com.github.javadojo.position.HeightComparator;
import com.github.javadojo.movement.MovingVector;
import com.github.javadojo.position.WidthComparator;
import com.github.javadojo.position.Position;

import static com.github.javadojo.MarsRover.LINE_SEPARATOR;

import java.util.ArrayList;
import java.util.List;

public class Path implements Drawable {
    private final List<PathPosition> pathPositions;


    public Path() {
        this.pathPositions = new ArrayList<>();
    }

    public void addPosition(Position position, MovingVector movingVector) {
        this.pathPositions.add(new PathPosition(new Position(position), movingVector));
    }

    public void makeSamplePosition() {
        this.pathPositions.get(this.pathPositions.size() - 1).makeSample();
    }

    public void changeDirection() {
        this.pathPositions.get(this.pathPositions.size() - 1).changeDirection();
    }

    @Override
    public String draw() {

        String[][] drawingMatrix = initializeMatrix(firstAndLastPosition()[0].distanceFromOtherPosition(firstAndLastPosition()[1]));
        int [] origin = new int[]{firstAndLastPosition()[0].x(), firstAndLastPosition()[0].y()};
        addIntermediatePosition(drawingMatrix, origin);
        addStartPoint(drawingMatrix, origin);
        addCurrentPosition(drawingMatrix, origin);
        return drawMatrix(drawingMatrix);
    }

    private String[][] initializeMatrix(int[] drawingMatrixDimension) {
        String[][] drawingMatrix = new String[drawingMatrixDimension[0]][drawingMatrixDimension[1]];
        for (int i = 0; i < drawingMatrix.length; i++) {
            for (int j = 0; j < drawingMatrix[i].length; j++) {
                drawingMatrix[i][j] = " ";
            }
        }
        return drawingMatrix;
    }

    private Position[] firstAndLastPosition() {
        ArrayList<PathPosition> comparingList = new ArrayList<>(pathPositions);
        comparingList.sort(new WidthComparator());
        int minX = comparingList.get(0).x();
        int maxX = comparingList.get(comparingList.size()-1).x();
        comparingList.sort(new HeightComparator());
        int minY = comparingList.get(0).y();
        int maxY = comparingList.get(comparingList.size()-1).y();
        return new Position[]{new Position(maxX,minY), new Position(minX,maxY)};
    }

    private void addIntermediatePosition(String[][] drawingMatrix, int [] origin) {
        for (int i = 1; i < this.pathPositions.size() - 1; i++) {
            PathPosition pathPosition = this.pathPositions.get(i);
            int x = -(pathPosition.x() - origin[0]);
            int y = pathPosition.y() - origin[1];
            if (pathPosition.draw().equals("S"))
                drawingMatrix[x][y] = pathPosition.draw();
            else {
                if (drawingMatrix[x][y].equals("-") ||
                        drawingMatrix[x][y].equals("|"))
                    drawingMatrix[x][y] = "+";
                else if(!drawingMatrix[x][y].equals("S") &&
                        !drawingMatrix[x][y].equals("X")) {
                    drawingMatrix[x][y] = pathPosition.draw();
                }
            }
        }
    }

    private void addStartPoint(String[][] drawingMatrix, int[] origin) {
        int xFirstPosition = this.pathPositions.get(0).x() - origin[0];
        int yFirstPosition = this.pathPositions.get(0).y() - origin[1];
        drawingMatrix[-xFirstPosition][yFirstPosition] = "X";
    }

    private void addCurrentPosition(String[][] drawingMatrix, int [] origin) {
        int xCurrentPosition = this.pathPositions.get(this.pathPositions.size() - 1).x() - origin[0];
        int yCurrentPosition = this.pathPositions.get(this.pathPositions.size() - 1).y() - origin[1];
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
