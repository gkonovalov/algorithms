package com.gkonovalov.datastructures.queues;

import com.gkonovalov.datastructures.etc.Node;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Queue implementation. Queue is FIFO(First in First Out) data structure.
 * </p>
 * Runtime Complexity: O(1) for {@code peek}, {@code pop}, {@code push}, {@code isEmpty}.
 * Space Complexity: O(n).
 */
public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        this.size = 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        return head.getValue();
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        T value = head.getValue();
        head = head.getNext();

        if (head == null) {
            tail = null;
        }
        size--;

        return value;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
