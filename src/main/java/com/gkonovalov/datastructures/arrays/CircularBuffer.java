package com.gkonovalov.datastructures.arrays;


/**
 * Created by Georgiy Konovalov on 10/06/2023.
 * <p>
 * Circular Buffer implementation, also known as a Ring Buffer, Circular Array or Circular Queue.
 * This is a data structure that uses a fixed-size array and keeps track of two pointers: front and rear.
 * It allows efficient insertion and deletion at both ends of the array by utilizing the concept of
 * modulo arithmetic. This enables continuous utilization of memory and avoids wastage of space,
 * making it suitable for scenarios where elements need to be added or removed in a cyclic manner.
 * </p>
 * Runtime Complexity: O(1) for {@code enqueue}, {@code dequeue}, {@code peek},
 *                              {@code isFull}, {@code isEmpty}, {@code size}.
 * Space Complexity:   O(n).
 */
public class CircularBuffer<T> {

    private static final int DEFAULT_SIZE = 8;

    private Object[] arr;

    private int start = 0;
    private int end = 0;

    private int size = 0;

    public CircularBuffer() {
        arr = new Object[DEFAULT_SIZE];
    }

    public CircularBuffer(int size) {
        arr = new Object[size];
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Circular Buffer is empty!");
        }

        return (T) arr[start];
    }

    public void enqueue(int data) {
        arr[end] = data;
        end = (end + 1) % arr.length;

        if (size < arr.length) {
            size++;
        } else {
            start = (start + 1) % arr.length;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Circular Buffer is empty!");
        }

        T result = (T) arr[start];

        arr[start] = null;
        start = (start + 1) % arr.length;
        size--;

        return result;
    }

    public boolean isFull() {
        return size() == arr.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }
}
