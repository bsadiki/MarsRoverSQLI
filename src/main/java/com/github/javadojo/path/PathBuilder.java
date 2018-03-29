package com.github.javadojo.path;

import com.github.javadojo.path.drawer.Drawer;
import com.github.javadojo.path.drawer.MatrixDrawer;
import com.github.javadojo.path.drawer.position.DrawerPositionFactory;
import com.github.javadojo.position.PositionSorter;

import java.util.ArrayList;

public class PathBuilder {
    public Path build(){
        PositionSorter positionSorter = new PositionSorter();
        MatrixDrawer matrixDrawer = new MatrixDrawer();
        DrawerPositionFactory drawerPositionFactory = new DrawerPositionFactory();
        Drawer drawer = new Drawer(positionSorter,  matrixDrawer, drawerPositionFactory);
        PathListConverter pathListConverter = new PathListConverter(positionSorter);
        return new Path(new ArrayList<>(),drawer,pathListConverter);
    }
}
