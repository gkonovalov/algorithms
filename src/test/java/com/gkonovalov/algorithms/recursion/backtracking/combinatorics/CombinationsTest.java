package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Tests for {@link Combinations}.
 * </p
 */
public class CombinationsTest {

    private Combinations combinations;

    @BeforeEach
    public void setUp() {
        this.combinations = new Combinations();
    }

    @Test
    @DisplayName("Testing Combinations.generateCombinations")
    public void testGenerateCombinations() {
        List<List<Integer>> expected = List.of(
                List.of(1, 2), List.of(1, 3), List.of(1, 4),
                List.of(2, 3), List.of(2, 4), List.of(3, 4)
        );
        assertEquals(expected, combinations.generateCombinations(4, 2));
    }
}
