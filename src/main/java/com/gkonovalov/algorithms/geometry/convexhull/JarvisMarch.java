package com.gkonovalov.algorithms.geometry.convexhull;

import java.util.*;

import static com.gkonovalov.algorithms.geometry.convexhull.Orientation.*;

/**
 * Created by Georgiy Konovalov on 1/1/2024.
 * <p>
 * The Jarvis March - is an algorithm used to find the Convex Hull of a set of points in a 2D plane.
 * The Convex Hull is the smallest convex polygon that encloses all the given points.
 *
 * Jarvis March, also known as the Gift Wrapping algorithm, iteratively selects the point
 * with the smallest polar angle relative to the current point. It starts with the leftmost point
 * (lowest x-coordinate) as the first point on the Convex Hull.
 *
 * The JarvisConvexHull algorithm has a worst-case time complexity of O(n h), where n is the
 * number of points and h is the number of points on the Convex Hull. Although it may be less
 * efficient than some other algorithms, it is simple to implement and suitable for small datasets.
 * </p>
 *
 * Runtime Complexity:  O(n h) - where n is the number of points and h is the number of points on the Convex Hull,
 *                      O(n^2) - worst case.
 * Space Complexity:    O(n).
 */
public class JarvisMarch {


    public List<Point> getConvexHull(Point[] points) throws IllegalArgumentException {
        if (points.length < 3) {
            throw new IllegalArgumentException("Can't create a Convex hull for less than 3 unique points!");
        }

        List<Point> convexHull = new ArrayList<>();

        int leftmost = getLeftmost(points);
        int current = leftmost;

        do {
            convexHull.add(points[current]);

            int nextPoint = (current + 1) % points.length;

            for (int i = 0; i < points.length; i++) {
                if (getOrientation(points[current], points[i], points[nextPoint]) == COUNTER_CLOCKWISE) {
                    nextPoint = i;
                }
            }

            current = nextPoint;

        } while (current != leftmost);

        return convexHull;
    }

    private Orientation getOrientation(Point a, Point b, Point c) {
        double crossProduct = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);

        if (crossProduct > 0) {
            return COUNTER_CLOCKWISE;
        } else if (crossProduct < 0) {
            return CLOCKWISE;
        } else {
            return COLLINEAR;
        }
    }

    private int getLeftmost(Point[] points) {
        int leftmost = 0;

        for (int i = 1; i < points.length; i++) {
            if (points[i].x < points[leftmost].x) {
                leftmost = i;
            }
        }

        return leftmost;
    }
}
