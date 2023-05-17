package com.gkonovalov.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Tests for {@link Stack}.
 * </p
 */
public class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        this.stack = new Stack<>();
    }

    @Test
    @DisplayName("Testing Stack.isEmpty")
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(5);

        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Testing Stack.push")
    public void testPop() {
        assertEquals(stack.size(), 0);

        stack.push(5);

        assertEquals(stack.size(), 1);
        assertEquals(stack.pop(), 5);
        assertEquals(stack.size(), 0);
    }

    @Test
    @DisplayName("Testing Stack.peek")
    public void testPeek() {
        assertEquals(stack.size(), 0);

        stack.push(5);

        assertEquals(stack.peek(), 5);
        assertEquals(stack.size(), 1);
    }

}
