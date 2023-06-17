package com.gkonovalov.datastructures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 8/06/2023.
 * <p>
 * Tests for {@link DynamicArray}.
 * </p
 */
public class DynamicArrayTest {

    private DynamicArray<Integer> dynamicArray;

    @BeforeEach
    public void setUp() {
        this.dynamicArray = new DynamicArray<>();
    }

    @Test
    @DisplayName("Testing DynamicArray.isEmpty")
    public void testIsEmpty() {
        assertTrue(dynamicArray.isEmpty());

        dynamicArray.add(5);

        assertFalse(dynamicArray.isEmpty());
    }

    @Test
    @DisplayName("Testing DynamicArray.add")
    public void testAdd() {
        assertEquals(dynamicArray.size(), 0);

        dynamicArray.add(5);

        assertEquals(dynamicArray.size(), 1);
        assertTrue(dynamicArray.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(100));
        assertEquals(dynamicArray.size(), 0);
    }

    @Test
    @DisplayName("Testing DynamicArray.remove")
    public void testRemove() {
        assertEquals(dynamicArray.size(), 0);

        dynamicArray.add(5);
        assertEquals(dynamicArray.size(), 1);

        dynamicArray.remove(0);

        assertThrows(IndexOutOfBoundsException.class, () -> dynamicArray.remove(100));
    }

    @Test
    @DisplayName("Testing DynamicArray.get")
    public void testAddLast() {
        assertEquals(dynamicArray.size(), 0);

        dynamicArray.add(5);

        assertEquals(dynamicArray.get(0), 5);
    }

    @Test
    @DisplayName("Testing DynamicArray.contains")
    public void testContains() {
        assertEquals(dynamicArray.size(), 0);

        dynamicArray.add(5);
        dynamicArray.add(2);

        assertTrue(dynamicArray.contains(2));
    }

    @Test
    @DisplayName("Testing DynamicArray.size")
    public void testSize() {
        assertEquals(dynamicArray.size(), 0);

        dynamicArray.add(5);
        dynamicArray.add(2);

        assertEquals(dynamicArray.size(), 2);
    }
}
