package com.gkonovalov.datastructures.hashtable;

import com.gkonovalov.datastructures.hashtables.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Tests for {@link HashMap}.
 * </p
 */
public class HashMapTest {

    private HashMap<String, Integer> hashMap;

    @BeforeEach
    public void setUp() {
        this.hashMap = new HashMap<>();
    }

    @Test
    @DisplayName("Testing HashMap.put")
    public void testPut() {
        assertTrue(hashMap.isEmpty());

        hashMap.put("a", 0);
        hashMap.put("b", 1);
        hashMap.put("b", 2);

        assertEquals(2, hashMap.size());
    }

    @Test
    @DisplayName("Testing HashMap.remove")
    public void testRemove() {
        assertEquals(hashMap.size(), 0);

        hashMap.put("a", 0);
        hashMap.put("b", 1);
        hashMap.put("c", 2);

        assertEquals(3, hashMap.size());
        assertTrue(hashMap.containsKey("b"));


        hashMap.remove("a");
        hashMap.remove("b");
        hashMap.remove("c");

        assertTrue(hashMap.isEmpty());
    }

    @Test
    @DisplayName("Testing HashMap.get")
    public void testGet() {
        assertEquals(0, hashMap.size());

        hashMap.put("a", 0);
        hashMap.put("b", 1);
        hashMap.put("c", 2);

        assertEquals(0, hashMap.get("a"));
        assertEquals(1, hashMap.get("b"));
        assertEquals(2, hashMap.get("c"));

        hashMap.put("a", 3);

        assertEquals(3, hashMap.get("a"));

        hashMap.remove("a");
        hashMap.remove("b");
        hashMap.remove("c");

        assertTrue(hashMap.isEmpty());
    }

    @Test
    @DisplayName("Testing HashMap.contains")
    public void testContains() {
        hashMap.put("a", 0);

        assertTrue(hashMap.containsKey("a"));
        assertFalse(hashMap.containsKey("b"));
    }

    @Test
    @DisplayName("Testing HashMap.keys")
    public void testKeys() {
        assertEquals(hashMap.size(), 0);

        List<String> keys = Arrays.asList("a", "b", "c");

        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i), i);
        }

        assertEquals(hashMap.size(), 3);

        assertEquals(keys.toString(), hashMap.keys().toString());
    }

    @Test
    @DisplayName("Testing HashSet.values")
    public void testValues() {
        assertEquals(hashMap.size(), 0);

        List<String> list = Arrays.asList("a", "b", "c");
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i), i);
            values.add(i);
        }

        assertEquals(hashMap.size(), 3);
        assertEquals(values.toString(), hashMap.values().toString());
    }

    @Test
    @DisplayName("Testing HashSet.size")
    public void testSize() {
        assertEquals(hashMap.size(), 0);

        hashMap.put("a", 1);

        assertEquals(hashMap.size(), 1);
    }
}
