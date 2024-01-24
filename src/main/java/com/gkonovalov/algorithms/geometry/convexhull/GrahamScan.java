package com.gkonovalov.algorithms.geometry.convexhull;

import java.util.*;

import static com.gkonovalov.algorithms.geometry.convexhull.Orientation.*;

/**
 * Created by Georgiy Konovalov on 30/12/2023.
 * <p>
 * The Graham Scan algorithm - is an algorithm used to find the Convex Hull
 * of a set of points in a 2D plane. The Convex Hull is the smallest convex polygon
 * that encloses all the given points. The algorithm operates by sorting the points
 * based on their Polar Angles with respect to a reference point and then constructing
 * the Convex Hull in a counterclockwise order.
 *
 * The Graham Scan algorithm has a worst-case time complexity of O(n log n), making
 * it an efficient algorithm for convex hull computation. It is an in-place algorithm,
 * meaning it operates directly on the input array of points, and it does not require
 * additional memory allocation proportional to the input size.
 *
 * Graham's Scan is more efficient than Jarvis March, especially for a large number of points.
 * </p>
 *
 * Runtime Complexity:  O(n log n) for sorting + O(n) for constructing the convex hull.
 * Space Complexity:    O(n).
 */
public class GrahamScan {

    public List<Point> getConvexHull(Point[] points) throws IllegalArgumentException {
        Arrays.sort(points, new PolarAngleComparator(getLowestPoint(points)));

        if (points.length < 3) {
            throw new IllegalArgumentException("Can't create a Convex hull for less than 3 unique points!");
        }

        if (isCollinear(points)) {
            throw new IllegalArgumentException("Can't create a Convex Hull from collinear points!");
        }

        Stack<Point> convexHull = new Stack<>();
        convexHull.push(points[0]);
        convexHull.push(points[1]);

        for (int i = 2; i < points.length; i++) {
            while (getOrientation(
                    convexHull.get(convexHull.size() - 2),
                    convexHull.peek(),
                    points[i]
            ) != COUNTER_CLOCKWISE) {
                convexHull.pop();
            }

            convexHull.push(points[i]);
        }

        return new ArrayList<>(convexHull);
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

    private Point getLowestPoint(Point[] points) {
        return Arrays.stream(points)
                .min(Comparator.comparing(Point::getX)
                        .thenComparing(Point::getY)).orElseThrow();
    }

    private double distanceSquared(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    private boolean isCollinear(Point[] points) {
        if (points.length < 2) {
            return true;
        }

        Point a = points[0];
        Point b = points[1];

        for (int i = 2; i < points.length; i++) {
            Point c = points[i];

            if (getOrientation(a, b, c) != COLLINEAR) {
                return false;
            }
        }

        return true;
    }

    private class PolarAngleComparator implements Comparator<Point> {

        private Point lowest;

        public PolarAngleComparator(Point lowest) {
            this.lowest = lowest;
        }

        public int compare(Point p1, Point p2) {
            Orientation orientation = getOrientation(lowest, p1, p2);

            switch (orientation) {
                case COLLINEAR:
                    return (distanceSquared(lowest, p1) <= distanceSquared(lowest, p2)) ? -1 : 1;
                case CLOCKWISE:
                    return 1;
                case COUNTER_CLOCKWISE:
                    return -1;
            }
            return 0;
        }
    }
}
