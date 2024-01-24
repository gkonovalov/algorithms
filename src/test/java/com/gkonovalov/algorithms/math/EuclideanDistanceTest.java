package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 24/1/2024.
 * <p>
 * Tests for {@link EuclideanDistance}.
 * </p
 */
public class EuclideanDistanceTest {

    private EuclideanDistance euclideanDistance;

    @BeforeEach
    public void setUp() {
        this.euclideanDistance = new EuclideanDistance();
    }

    @Test
    @DisplayName("Testing EuclideanDistance.calculateDistance")
    public void testCalculateDistance() {
        assertEquals(5, euclideanDistance.calculateDistance(1,2,4,6));
    }
}
