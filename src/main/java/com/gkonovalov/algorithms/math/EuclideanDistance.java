package com.gkonovalov.algorithms.math;

/**
 * Created by Georgiy Konovalov on 24/1/2024.
 * <p>
 * The Euclidean Distance algorithm  implementation.
 * The Euclidean Distance algorithm calculates the straight-line distance
 * between two points in Euclidean space.
 * </p>
 *
 * Runtime Complexity: O(1) for {@code calculateDistance}.
 * Space Complexity:   O(1) for {@code calculateDistance}.
 */
public class EuclideanDistance {

    public double calculateDistance(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
