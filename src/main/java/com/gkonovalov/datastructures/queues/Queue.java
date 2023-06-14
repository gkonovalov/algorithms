package com.gkonovalov.datastructures.queues;

import com.gkonovalov.datastructures.etc.ListNode;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Queue implementation. Queue is FIFO(First in First Out) data structure.
 * </p>
 * Runtime Complexity: O(1) for {@code peek}, {@code pop}, {@code push}, {@code isEmpty}.
 * Space Complexity:   O(n).
 */
public class Queue<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public Queue() {
        this.size = 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        return head.value;
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        T value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;

        return value;
    }

    public void add(T value) {
        ListNode<T> newListNode = new ListNode<>(value);

        if (isEmpty()) {
            head = newListNode;
        } else {
            tail.next = newListNode;
        }
        tail = newListNode;

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
