package com.gkonovalov.algorithms.geometry.convexhull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by Georgiy Konovalov on 1/1/2024.
 * <p>
 * Tests for {@link JarvisScan}.
 * </p
 */
public class JarvisScanTest {

    private JarvisScan jarvisScan;

    @BeforeEach
    public void setUp() {
        this.jarvisScan = new JarvisScan();
    }

    @Test
    @DisplayName("Testing JarvisScan.getConvexHull")
    public void testGetConvexHull() {
        Point[] points = {
                new Point(0, 3),
                new Point(1, 1),
                new Point(2, 2),
                new Point(4, 4),
                new Point(0, 0),
                new Point(1, 2),
                new Point(3, 1),
                new Point(3, 3)
        };

        Point[] expected = {
                new Point(0, 3),
                new Point(0, 0),
                new Point(3, 1),
                new Point(4, 4),

        };

        List<Point> actual = jarvisScan.getConvexHull(points);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].getX(), actual.get(i).getX());
            assertEquals(expected[i].getY(), actual.get(i).getY());
        }
    }

}
