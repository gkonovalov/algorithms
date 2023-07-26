package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Tests for {@link Subsets}.
 * </p
 */
public class SubsetsTest {

    private Subsets subsets;

    @BeforeEach
    public void setUp() {
        this.subsets = new Subsets();
    }

    @Test
    @DisplayName("Testing Subsets.generateSubsets")
    public void testGenerateSubsets() {
        List<List<Integer>> expected = List.of(
                List.of(), List.of(1), List.of(1, 2), List.of(2)
        );
        assertEquals(expected, subsets.generateSubsets(new int[]{1, 2}));
    }
}
