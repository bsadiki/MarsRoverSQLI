package com.github.javadojo.path;

import com.github.javadojo.position.Position;
import com.github.javadojo.position.PositionSorter;

import java.util.ArrayList;
import java.util.List;

public class PathListConverter {
    private final PositionSorter positionSorter;

    public PathListConverter(PositionSorter positionSorter) {
        this.positionSorter = positionSorter;
    }

    public  List<PathPosition> convertToDrawable(List<PathPosition> pathPositions) {
        List<PathPosition> drawingPathPositions = reverse(pathPositions);
        adjustToOrigin(drawingPathPositions);
        return drawingPathPositions;
    }

    private  List<PathPosition> reverse(List<PathPosition> drawingPathPosition) {
        List<PathPosition> reversedPathPosition = new ArrayList<>();
        drawingPathPosition.forEach(pathPosition -> {
            reversedPathPosition.add(pathPosition.reverse());
        });
        return reversedPathPosition;
    }

    private  void adjustToOrigin(List<PathPosition> drawingPathPositions) {
        Position origin = getOrigin(drawingPathPositions);
        drawingPathPositions.forEach(drawingPathPosition -> {
            drawingPathPosition.adjustToOrigin(origin);
        });
    }

    private  Position getOrigin(List<PathPosition> drawingPathPosition) {
        return new Position(positionSorter.firstAndLastPosition(drawingPathPosition)[0]);
    }

}
