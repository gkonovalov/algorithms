package com.gkonovalov.datastructures.hashtables;

import java.util.*;

/**
 * Created by Georgiy Konovalov on 15/06/2023.
 * <p>
 * HashSet data structure implementation with dynamic resizing feature. This data structure that stores
 * a collection of unique elements in no particular order, provides efficient insertion, deletion, and
 * lookup operations for determining whether and element is present in the set.
 * Current implementation support Open Addressing (Linear Probing) collision resolution strategy and
 * dynamic resizing feature.
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

    public boolean add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Parameter value can't be null!");
        }

        expandArray();

        Integer address = linearProbingSearch(getHash(value), value, true);
        if (address != null) {
            set[address] = value;
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Parameter value can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Set is empty!");
        }

        shrinkArray();

        Integer address = linearProbingSearch(getHash(value), value, false);
        if (address != null) {
            set[address] = null;
            size--;
            rehashCluster(address);
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Parameter value can't be null!");
        }

        if (isEmpty()) {
            throw new IllegalStateException("Hash Set is empty!");
        }
        return linearProbingSearch(getHash(value), value, false) != null;
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

    private Integer linearProbingSearch(int hash, T value, boolean searchEmptySpot) {
        while (set[hash] != null) {
            if (set[hash].equals(value)) {
                return !searchEmptySpot ? hash : null;
            }

            hash = (hash + 1) % set.length;
        }
        return searchEmptySpot ? hash : null;
    }

    private void resize(int capacity) {
        HashSet<T> newSet = new HashSet<>(capacity);

        for (T item : set) {
            if (item != null) {
                newSet.add(item);
            }
        }
        set = newSet.set;
    }

    private void expandArray() {
        if (size >= set.length / 2) {
            resize(set.length * 2);
        }
    }

    private void shrinkArray() {
        if (size >= 0 && size == set.length / 4) {
            resize(set.length / 2);
        }
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
