package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Tests for {@link Permutations}.
 * </p
 */
public class PermutationsTest {

    private Permutations permutations;

    @BeforeEach
    public void setUp() {
        this.permutations = new Permutations();
    }

    @Test
    @DisplayName("Testing Permutations.generatePermutations")
    public void testGeneratePermutations() {
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
                List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)
        );
        assertEquals(expected, permutations.generatePermutations(new int[]{1, 2, 3}));
    }
}
