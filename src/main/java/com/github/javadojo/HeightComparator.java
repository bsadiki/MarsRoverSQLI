package com.github.javadojo;

import java.util.Comparator;

public class HeightComparator implements Comparator<PathPosition> {
    @Override
    public int compare(PathPosition pathPosition1, PathPosition pathPosition2) {
        return Integer.compare(pathPosition1.y(),pathPosition2.y());
    }
}
