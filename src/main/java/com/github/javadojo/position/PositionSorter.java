package com.github.javadojo.position;

import com.github.javadojo.path.PathPosition;

import java.util.ArrayList;
import java.util.List;

public class PositionSorter {

    public Position[] firstAndLastPosition(List<PathPosition> drawingPathPosition) {
        ArrayList<PathPosition> comparingList = new ArrayList<>(drawingPathPosition);
        comparingList.sort(new WidthComparator());
        int minX = comparingList.get(0).getX();
        int maxX = comparingList.get(comparingList.size() - 1).getX();
        comparingList.sort(new HeightComparator());
        int minY = comparingList.get(0).getY();
        int maxY = comparingList.get(comparingList.size() - 1).getY();
        return new Position[]{new Position(maxX, minY), new Position(minX, maxY)};
    }
}
