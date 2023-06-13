package com.gkonovalov.datastructures.trees.heaps;

import java.util.Comparator;

/**
 * Created by Georgiy Konovalov on 13/06/2023.
 * <p>
 * Binary heap data structure implementation, also known as a Priority Queue. Current implementation supports
 * both Min Heap and Max Heap functionality, utilizing a comparator to achieve this.
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
public class BinaryHeap<T extends Comparable<T>> {

    private static final int DEFAULT_SIZE = 8;
    private static final int ROOT = 1;

    private final T[] arr;
    private int n;

    private final Comparator<? super T> comparator;

    public BinaryHeap() {
        this(DEFAULT_SIZE, Comparator.naturalOrder());
    }

    public BinaryHeap(Comparator<T> comparator) {
        this(DEFAULT_SIZE, comparator);
    }

    public BinaryHeap(int capacity, Comparator<T> comparator) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can't be <= 0!");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("Comparator can't be null!");
        }

        this.comparator = comparator;
        this.arr = (T[]) new Comparable[capacity + 1];
        this.n = 0;
    }

    public void add(T item) {
        if (n >= arr.length - 1) {
            throw new IllegalStateException("Binary Heap is full!");
        }

        n++;
        arr[n] = item;
        moveUp(n);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Heap is empty!");
        }

        return arr[ROOT];
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Binary Heap is empty!");
        }

        T item = arr[ROOT];
        swap(ROOT, n);
        moveDown(ROOT);
        arr[n] = null;
        n--;

        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
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

    private boolean less(int i, int j) {
        return comparator.compare(arr[i], arr[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
