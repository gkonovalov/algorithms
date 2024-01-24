package com.gkonovalov.algorithms.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 24/05/2024.
 * <p>
 * Tests for {@link LeastCommonMultiple}.
 * </p
 */
public class LeastCommonMultipleTest {

    private LeastCommonMultiple lcm;

    @BeforeEach
    public void setUp() {
        this.lcm = new LeastCommonMultiple();
    }

    @Test
    @DisplayName("Testing LeastCommonMultiple.calculate")
    public void testCalculate() {
        assertEquals(36, lcm.calculate(12, 18));
    }
}
