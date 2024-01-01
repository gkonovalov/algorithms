package com.gkonovalov.algorithms.geometry.convexhull;

/**
 * Created by Georgiy Konovalov on 1/1/2024.
 * <p>
 * Paint class used in Convex Hull computation.
 * </p>
 */
public class Point {

    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
