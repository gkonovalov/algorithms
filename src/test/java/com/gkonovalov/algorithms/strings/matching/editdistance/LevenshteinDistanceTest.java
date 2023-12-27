package com.gkonovalov.algorithms.strings.matching.editdistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 27/06/2023.
 * <p>
 * Tests for {@link LevenshteinDistance}.
 * </p
 */
public class LevenshteinDistanceTest {

    private LevenshteinDistance levenshteinDistance;

    @BeforeEach
    public void setUp() {
        this.levenshteinDistance = new LevenshteinDistance();
    }

    @Test
    @DisplayName("Testing LevenshteinDistance.calculateDistance")
    public void testSearchIteratively() {
        assertEquals(1, levenshteinDistance.calculateDistance("cat", "mat"));
        assertEquals(3, levenshteinDistance.calculateDistance("cat", "dog"));
        assertEquals(5, levenshteinDistance.calculateDistance("dark", "matter"));
    }
}
