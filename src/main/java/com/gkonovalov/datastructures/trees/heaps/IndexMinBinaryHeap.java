package com.gkonovalov.datastructures.trees.heaps;

import java.util.NoSuchElementException;

/**
 * Created by Georgiy Konovalov on 13/06/2023.
 * <p>
 * Indexed Binary heap data structure implementation, also known as a Priority Queue.
 * Current implementation supports both Min Heap and Max Heap functionality, utilizing a comparator to achieve this.
 * Binary heap is a binary tree-based data structure that satisfy the heap property, which means that for every
 * node i other than the root, the key value of the parent node is either greater (in a max heap) or
 * smaller (in a min heap) than or equal to the key value of node i. This property allows quick access to the
 * maximum (or minimum) element at the root of the heap. Binary heaps are typically implemented using an array,
 * where the elements are stored in a complete binary tree fashion.
 * The left child of a node at index i is stored at index 2i and the right child is stored at index 2i+1,
 * and parent of node at index i is stored at i/2.
 * </p>
 * Runtime Complexity: O(log n) for {@code add}, {@code poll}, {@code moveUp}, {@code moveDown},
 *                     O(1) for {@code peek}, {@code isFull}, {@code isEmpty}, {@code size}.
 * Space Complexity:   O(n).
 */
public class IndexMinBinaryHeap<T extends Comparable<T>> {

    private static final int DEFAULT_SIZE = 8;
    private static final int ROOT = 1;

    private T[] keys;
    private int[] pq;
    private int[] qp;
    private int capacity;
    private int n;

    public IndexMinBinaryHeap() {
        this(DEFAULT_SIZE);
    }

    public IndexMinBinaryHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can't be <= 0!");
        }

        this.capacity = capacity;
        this.n = 0;
        this.keys = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            qp[i] = -1;
        }
    }

    public void insert(int i, T key) {
        if (contains(i)) {
            throw new IllegalArgumentException("Index is already in the Binary Heap!");
        }

        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        moveUp(n);
    }

    public int minIndex() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Heap is empty!");
        }
        return pq[ROOT];
    }

    public T minKey() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Heap is empty!");
        }
        return keys[pq[ROOT]];
    }

    public T keyOf(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }
        return keys[i];
    }

    public void decreaseKey(int i, T key) {
        if (!contains(i)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }
        if (keys[i].compareTo(key) == 0) {
            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the Binary Heap");
        }
        if (keys[i].compareTo(key) < 0) {
            throw new IllegalArgumentException("Calling decreaseKey() with a key strictly greater than the key in the Binary Heap");
        }

        keys[i] = key;
        moveUp(qp[i]);
    }

    public void increaseKey(int i, T key) {
        if (!contains(i)) {
            throw new NoSuchElementException("index is not in the Binary Heap");
        }
        if (keys[i].compareTo(key) == 0) {
            throw new IllegalArgumentException("Calling increaseKey() with a key equal to the key in the Binary Heap");
        }
        if (keys[i].compareTo(key) > 0) {
            throw new IllegalArgumentException("Calling increaseKey() with a key strictly less than the key in the Binary Heap");
        }

        keys[i] = key;
        moveDown(qp[i]);
    }

    public void delete(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }

        int index = qp[i];
        swap(index, n--);
        moveUp(index);
        moveDown(index);

        keys[i] = null;
        qp[i] = -1;
    }

    public void changeKey(int i, T key) {
        if (!contains(i)) {
            throw new NoSuchElementException("Index is not in the Binary Heap!");
        }

        keys[i] = key;
        moveUp(qp[i]);
        moveDown(qp[i]);
    }

    public int delMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Heap is empty!");
        }

        int min = pq[ROOT];
        swap(ROOT, n--);
        moveDown(ROOT);

        assert min == pq[n + 1];

        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;

        return min;
    }

    public boolean contains(int i) {
        if (i < 0 || i >= capacity) {
            throw new IllegalArgumentException("Invalid index: " + i);
        }
        return qp[i] != -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void swap(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void moveUp(int child) {
        int parent = child / 2;

        while (child > ROOT && less(parent, child)) {
            swap(child, parent);
            child = parent;
            parent = child / 2;
        }
    }

    private void moveDown(int parent) {
        int largest = parent;
        int left = 2 * parent;
        int right = 2 * parent + 1;

        if (left < n && less(largest, left)) {
            largest = left;
        }

        if (right < n && less(largest, right)) {
            largest = right;
        }

        if (largest != parent) {
            swap(parent, largest);
            moveDown(largest);
        }
    }
}
