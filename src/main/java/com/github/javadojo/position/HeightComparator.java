package com.github.javadojo.position;

import com.github.javadojo.path.PathPosition;

import java.util.Comparator;

public class HeightComparator implements Comparator<PathPosition> {
    @Override
    public int compare(PathPosition pathPosition1, PathPosition pathPosition2) {
        return Integer.compare(pathPosition1.getY(),pathPosition2.getY());
    }
}
