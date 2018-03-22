package com.github.javadojo;

import java.util.Comparator;

public class WidthComparator implements Comparator<PathPosition> {
    @Override
    public int compare(PathPosition pathPosition1, PathPosition pathPosition2) {
        return Integer.compare(pathPosition1.x(),pathPosition2.x());
    }
}
