package com.gkonovalov.algorithms.strings.matching.editdistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Georgiy Konovalov on 27/06/2023.
 * <p>
 * Tests for {@link HammingDistance}.
 * </p
 */
public class HammingDistanceTest {

    private HammingDistance hammingDistance;

    @BeforeEach
    public void setUp() {
        this.hammingDistance = new HammingDistance();
    }

    @Test
    @DisplayName("Testing HammingDistance.calculateDistance")
    public void testSearchIteratively() {
        assertEquals(1, hammingDistance.calculateDistance("cat", "mat"));
        assertEquals(3, hammingDistance.calculateDistance("cat", "dog"));
        assertThrows(IllegalArgumentException.class, () -> hammingDistance.calculateDistance("dark", "matter"));
    }
}
