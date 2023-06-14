package com.gkonovalov.datastructures.queues;

import com.gkonovalov.datastructures.etc.DoubleListNode;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Deque implementation. A Deque, short for "double-ended queue," is data structure
 * where elements can be added or removed from the head or the back of the deque.
 * </p>
 * Runtime Complexity: O(1) for {@code addFirst}, {@code addLast},
 *                              {@code removeFirst}, {@code removeLast},
 *                              {@code peekFirst}, {@code peekLast},
 *                              {@code isEmpty}, {@code size}.
 * Space Complexity:   O(n).
 */
public class Deque<T> {

    private DoubleListNode<T> head;
    private DoubleListNode<T> tail;
    private int size;

    public Deque() {
        this.size = 0;
    }

    public void addFirst(T value) {
        DoubleListNode<T> newNode = new DoubleListNode<>(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        DoubleListNode<T> newNode = new DoubleListNode<>(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }

        T data = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;

        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }

        T data = tail.value;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;

        return data;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        return head.value;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
