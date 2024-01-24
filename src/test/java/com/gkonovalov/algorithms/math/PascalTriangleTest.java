package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 1/24/2024.
 * <p>
 * Tests for {@link PascalTriangle}.
 * </p
 */
public class PascalTriangleTest {

    private PascalTriangle pascalTriangle;

    @BeforeEach
    public void setUp() {
        this.pascalTriangle = new PascalTriangle();
    }

    @Test
    @DisplayName("Testing PascalTriangle.generate")
    public void testGenerate() {
        List<List<Integer>> expected = List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
        );

        assertEquals(expected, pascalTriangle.generate(5));
    }
}
