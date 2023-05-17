package com.gkonovalov.datastructures.queues;

import com.gkonovalov.datastructures.etc.DNode;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Deque implementation. A Deque, short for "double-ended queue," is data structure
 * where elements can be added or removed from the head or the back of the deque.
 * </p>
 * Runtime Complexity: O(1) for {@code addFirst}, {@code addLast};
 *                              {@code removeFirst}, {@code removeLast};
 *                              {@code peekFirst}, {@code peekLast};
 *                              {@code isEmpty}, {@code size}.
 * Space Complexity: O(n).
 */
public class Deque<T> {

    private DNode<T> head;
    private DNode<T> tail;
    private int size;

    public Deque() {
        this.size = 0;
    }

    public void addFirst(T value) {
        DNode<T> newNode = new DNode<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        DNode<T> newNode = new DNode<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }

        T data = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        size--;

        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }

        T data = tail.getValue();
        tail = tail.getPrev();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size--;

        return data;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        return head.getValue();
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
        return tail.getValue();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
