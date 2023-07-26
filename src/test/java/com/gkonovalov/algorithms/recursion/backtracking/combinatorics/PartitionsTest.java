package com.gkonovalov.algorithms.recursion.backtracking.combinatorics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Georgiy Konovalov on 26/07/2023.
 * <p>
 * Tests for {@link Partitions}.
 * </p
 */
public class PartitionsTest {

    private Partitions partitions;

    @BeforeEach
    public void setUp() {
        this.partitions = new Partitions();
    }

    @Test
    @DisplayName("Testing Partitions.generatePartitions")
    public void testGeneratePartitions() {
        List<List<Integer>> expected = List.of(List.of(1, 1, 1), List.of(2, 1), List.of(3));
        assertEquals(expected, partitions.generatePartitions(3,3));
    }
}
