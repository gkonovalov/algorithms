package com.gkonovalov.datastructures.hashtables;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 15/06/2023.
 * <p>
 * HashSet data structure implementation with dynamic resizing feature.
 * HashSet is a data structure that stores a collection of unique elements in no particular order.
 * It provides efficient insertion, deletion, and lookup operations for determining whether an
 * element is present in the set.
 * Current implementation support Open Addressing (Linear Probing) collision resolution strategy.
 *
 * The core idea behind a HashSet is to use a hash function to compute an index, or a hash code, for each key.
 * If a collision occurs, the algorithm probes for the next available bucket until an empty slot is found.
 * This can involve Linear Probing (checking the next consecutive bucket) or other methods like
 * Two-probe Hashing, Double Hashing or Cuckoo Hashing.
 * </p>
 * Runtime Complexity: O(1) for {@code add}, {@code remove}, {@code contains},
 *                              {@code isEmpty}, {@code size},
 *                     O(n) for {@code keys}.
 * Space Complexity:   O(n).
 */
public class HashSet<T> {

    private static final int DEFAULT_SIZE = 8;

    private T[] set;

    private int size;

    public HashSet() {
        this(DEFAULT_SIZE);
    }

    public HashSet(int capacity) {
        this.size = 0;
        this.set = (T[]) new Object[capacity];
    }

    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Parameter value can't be null!");
        }

        if (size >= set.length / 2) {
            resize(2 * set.length);
        }

        int hash = getHash(value);

        while (set[hash] != null) {
            if (set[hash].equals(value)) {
                return;
            }
            hash = (hash + 1) % set.length;
        }

        set[hash] = value;
        size++;
    }

    public boolean remove(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Parameter value can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Set is empty!");
        }

        int hash = getHash(value);

        while (!value.equals(set[hash])) {
            hash = (hash + 1) % set.length;
        }

        set[hash] = null;
        size--;

        rehashCluster(hash);

        if (size > 0 && size <= set.length / 8) {
            resize(set.length / 2);
        }

        return true;
    }

    public boolean contains(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Parameter value can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Set is empty!");
        }

        int hash = getHash(value);

        while (set[hash] != null) {
            if (set[hash].equals(value)) {
                return true;
            }
            hash = (hash + 1) % set.length;
        }

        return false;
    }

    public Iterable<T> keys() {
        Queue<T> result = new ArrayDeque<>();

        for (T item : set) {
            if (item != null) {
                result.add(item);
            }
        }

        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        HashSet<T> newSet = new HashSet<>(capacity);

        for (int i = 0; i < set.length; i++) {
            if (set[i] != null) {
                newSet.add(set[i]);
            }
        }

        set = newSet.set;
    }

    private void rehashCluster(int index) {
        int hash = (index + 1) % set.length;

        while (set[hash] != null) {
            T keyToRehash = set[hash];
            set[hash] = null;
            size--;
            add(keyToRehash);

            hash = (hash + 1) % set.length;
        }
    }

    private int getHash(T element) {
        return (element.hashCode() & 0x7fffffff) % set.length;
    }
}
