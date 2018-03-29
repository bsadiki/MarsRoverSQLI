package com.github.javadojo.path;

import com.github.javadojo.path.drawer.Drawer;
import com.github.javadojo.path.drawer.MatrixDrawer;
import com.github.javadojo.path.drawer.position.DrawerPostionFactory;
import com.github.javadojo.position.PositionSorter;

import java.util.ArrayList;

public class PathBuilder {
    public Path build(){
        PositionSorter positionSorter = new PositionSorter();
        MatrixDrawer matrixDrawer = new MatrixDrawer();
        DrawerPostionFactory drawerPostionFactory = new DrawerPostionFactory();
        Drawer drawer = new Drawer(positionSorter,  matrixDrawer, drawerPostionFactory);
        PathListConverter pathListConverter = new PathListConverter(positionSorter);
        return new Path(new ArrayList<>(),drawer,pathListConverter);
    }
}
