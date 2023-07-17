package com.gkonovalov.datastructures.trees.heaps;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Georgiy Konovalov on 13/06/2023.
 * <p>
 * Indexed Binary Heap data structure implementation, also known as a Indexed Priority Queue.
 * Current implementation supports both Min Heap and Max Heap functionality, utilizing a comparator to achieve this.
 * Indexed Binary Heap, is a data structure that combines the properties of a Binary Heap and an Array with additional
 * indexing capabilities. It is designed to efficiently perform operations like insertion, deletion, and updating of
 * elements, while also allowing direct access to the elements by their indices. Indexed Binary Heap satisfy the
 * heap property, which means that for every node i other than the root, the key value of the parent node is either
 * greater (in a max heap) or smaller (in a min heap) than or equal to the key value of node i. This property allows
 * quick access to the maximum (or minimum) element at the root of the heap. Binary heaps are typically implemented
 * using an array, where the elements are stored in a complete binary tree fashion.
 * The left child of a node at index i is stored at index 2i and the right child is stored at index 2i+1,
 * and parent of node at index i is stored at i/2.
 * </p>
 * Runtime Complexity: O(log n) for {@code insert}, {@code poll}, {@code moveUp}, {@code moveDown},
 *                     O(1) for {@code peek}, {@code isFull}, {@code isEmpty}, {@code size}.
 * Space Complexity:   O(n).
 */
public class IndexedBinaryHeap<T extends Comparable<T>> {

    private static final int DEFAULT_SIZE = 8;
    private static final int ROOT = 1;

    private final Type type;

    private T[] keys;
    private int[] pq;
    private int[] qp;
    private int capacity;
    private int n;

    public IndexedBinaryHeap() {
        this(DEFAULT_SIZE, Type.MAX);
    }

    public IndexedBinaryHeap(Type type) {
        this(DEFAULT_SIZE, type);
    }

    public IndexedBinaryHeap(int capacity, Type type) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can't be <= 0!");
        }

        if (type == null) {
            throw new IllegalArgumentException("Type can't be null!");
        }

        this.capacity = capacity;
        this.type = type;
        this.n = 0;
        this.keys = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];

        Arrays.fill(qp, -1);
    }

    public void insert(int index, T key) {
        if (contains(index)) {
            throw new IllegalArgumentException("Index is already in the Binary Heap!");
        }

        n++;
        qp[index] = n;
        pq[n] = index;
        keys[index] = key;
        moveUp(n);
    }

    public int peekIndex() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Heap is empty!");
        }

        return pq[ROOT];
    }

    public T peekKey() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Heap is empty!");
        }

        return keys[pq[ROOT]];
    }

    public int pollIndex() {
        int top = peekIndex();

        swap(ROOT, n--);
        moveDown(ROOT);

        assert top == pq[n + 1];

        qp[top] = -1;
        keys[top] = null;
        pq[n + 1] = -1;

        return top;
    }

    public T pollKey() {
        T key = peekKey();

        pollIndex();

        return key;
    }

    public void delete(int index) {
        if (!contains(index)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }

        int i = qp[index];
        swap(i, n--);
        moveUp(i);
        moveDown(i);

        keys[index] = null;
        qp[index] = -1;
    }

    public void changeKey(int index, T key) {
        if (!contains(index)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }

        keys[index] = key;
        moveUp(qp[index]);
        moveDown(qp[index]);
    }

    public T keyOf(int index) {
        if (!contains(index)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }

        return keys[index];
    }

    public void decreaseKey(int index, T key) {
        if (!contains(index)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }

        if (keys[index].compareTo(key) == 0) {
            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the Binary Heap");
        }

        if (keys[index].compareTo(key) < 0) {
            throw new IllegalArgumentException("Calling decreaseKey() with a key strictly greater than the key in the Binary Heap");
        }

        keys[index] = key;

        if (type.equals(Type.MIN)) {
            moveUp(qp[index]);
        } else {
            moveDown(qp[index]);
        }
    }

    public void increaseKey(int index, T key) {
        if (!contains(index)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }

        if (keys[index].compareTo(key) == 0) {
            throw new IllegalArgumentException("Calling increaseKey() with a key equal to the key in the Binary Heap");
        }

        if (keys[index].compareTo(key) > 0) {
            throw new IllegalArgumentException("Calling increaseKey() with a key strictly less than the key in the Binary Heap");
        }

        keys[index] = key;

        if (type.equals(Type.MIN)) {
            moveDown(qp[index]);
        } else {
            moveUp(qp[index]);
        }
    }

    public boolean contains(int index) {
        if (index < 0 || index >= capacity) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        return qp[index] != -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void swap(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean compare(int i, int j) {
        switch (type) {
            case MAX:
                return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
            case MIN:
                return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
        }
        return false;
    }

    private void moveUp(int child) {
        int parent = child / 2;

        while (child > ROOT && compare(parent, child)) {
            swap(child, parent);
            child = parent;
            parent = child / 2;
        }
    }

    private void moveDown(int parent) {
        int largest = parent;
        int left = 2 * parent;
        int right = 2 * parent + 1;

        if (left <= n && compare(largest, left)) {
            largest = left;
        }

        if (right <= n && compare(largest, right)) {
            largest = right;
        }

        if (largest != parent) {
            swap(parent, largest);
            moveDown(largest);
        }
    }

    public enum Type {
        MIN,
        MAX
    }
}
