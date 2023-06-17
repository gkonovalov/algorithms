package com.gkonovalov.datastructures.hashtable;

import com.gkonovalov.datastructures.hashtables.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 15/06/2023.
 * <p>
 * Tests for {@link HashSet}.
 * </p
 */
public class HashSetTest {

    private HashSet<String> hashSet;

    @BeforeEach
    public void setUp() {
        this.hashSet = new HashSet<>();
    }

    @Test
    @DisplayName("Testing HashSet.add")
    public void testAdd() {
        assertTrue(hashSet.isEmpty());

        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("a");

        assertEquals(hashSet.size(), 2);
    }

    @Test
    @DisplayName("Testing HashSet.remove")
    public void testRemove() {
        assertEquals(hashSet.size(), 0);

        hashSet.add("a");
        hashSet.add("a");

        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("d");
        hashSet.add("e");
        hashSet.add("g");
        hashSet.add("n");
        hashSet.add("z");
        hashSet.add("p");

        assertEquals(hashSet.size(), 9);
        assertTrue(hashSet.contains("a"));

        hashSet.remove("a");
        hashSet.remove("b");
        hashSet.remove("c");
        hashSet.remove("d");
        hashSet.remove("e");
        hashSet.remove("g");
        hashSet.remove("n");
        hashSet.remove("z");
        hashSet.remove("p");

        assertTrue(hashSet.isEmpty());
    }

    @Test
    @DisplayName("Testing HashSet.contains")
    public void testContains() {
        hashSet.add("a");
        hashSet.add("a");

        assertTrue(hashSet.contains("a"));
        assertFalse(hashSet.contains("b"));
    }

    @Test
    @DisplayName("Testing HashSet.keys")
    public void testKeys() {
        assertEquals(hashSet.size(), 0);

        List<String> keys = Arrays.asList("a", "b", "c");

        for (int i = 0; i < keys.size(); i++) {
            hashSet.add(keys.get(i));
        }

        assertEquals(hashSet.size(), 3);
        assertIterableEquals(keys, hashSet.keys());
    }

    @Test
    @DisplayName("Testing HashSet.size")
    public void testSize() {
        assertEquals(hashSet.size(), 0);

        hashSet.add("a");

        assertEquals(hashSet.size(), 1);
    }
}
