package com.gkonovalov.datastructures.linkedlist;


import java.util.Objects;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Doubly Linked List implementation.
 * A linked list is a linear data structure in which elements are stored as individual nodes,
 * where each node contains a value and a reference (or link) to the next node in the sequence.
 * Unlike arrays, linked lists do not require contiguous memory allocation, allowing for efficient
 * insertion and deletion operations. In a doubly linked list, each node contains references to both
 * the next node and the previous node in the list. This allows for traversal in both directions.
 * Linked lists are dynamic data structures, meaning they can grow or shrink in size during program
 * execution. They are commonly used when the number of elements is unknown or can change frequently,
 * or when efficient insertion and deletion operations are required. However, linked lists have slower
 * access times compared to arrays since accessing an element requires traversing the list from
 * the beginning.
 * <p>
 * Runtime Complexity: O(1) for the {@code add}, {@code prepend}, {@code append},
 *                                  {@code size}, {@code removeFirst} and {@code removeLast},
 *                     O(n) for the {@code get}, {@code indexOf}, {@code contains},
 *                                  {@code findNode}, and {@code remove}.
 * Space Complexity:   O(n).
 */
public class DoublyLinkedList<T> {

    private DoubleListNode<T> head;
    private DoubleListNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;

        this.head = new DoubleListNode<>();
        this.tail = new DoubleListNode<>();

        this.head.next = tail;
        this.tail.prev = head;
    }

    public void add(T value) {
        append(value);
    }

    public void add(T value, int position) {
        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        if (isEmpty() || position == 0) {
            prepend(value);
            return;
        }

        DoubleListNode<T> prevNode = findNode(position - 1);
        if (prevNode != null) {
            DoubleListNode<T> newNode = new DoubleListNode<>(value);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    public T get(int position) {
        if (isEmpty()) {
            throw new IllegalStateException("Double Linked List is empty!");
        }

        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        DoubleListNode<T> current = findNode(position);

        if (current != null) {
            return current.value;
        }
        return null;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        if (isEmpty()) {
            throw new IllegalStateException("Double Linked List is empty!");
        }

        int index = 0;

        DoubleListNode<T> current = head.next;

        while (current != null) {
            if (Objects.equals(value, current.value)) {
                return index;
            }

            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Double Linked List is empty!");
        }

        head.next.next.prev = head;
        head.next = head.next.next;

        size--;
        return true;
    }

    public boolean removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Double Linked List is empty!");
        }

        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;

        size--;
        return true;
    }

    public boolean remove(int position) {
        if (isEmpty()) {
            throw new IllegalStateException("Double Linked List is empty!");
        }

        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        if (position == 0) {
            head = head.next;
            size--;
            return true;
        }

        DoubleListNode<T> current = findNode(position - 1);

        if (current != null) {
            current.next.prev = current.prev;
            current.prev.next = current.next;
            size--;

            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void append(T value) {
        DoubleListNode<T> newNode = new DoubleListNode<>(value);
        newNode.prev = tail.prev;
        newNode.prev.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
    }

    private void prepend(T value) {
        DoubleListNode<T> newNode = new DoubleListNode<>(value);
        newNode.next = head.next;
        newNode.next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
        size++;
    }

    private DoubleListNode<T> findNode(int index) {
        if (isEmpty()) {
            return null;
        }

        DoubleListNode<T> current = head.next;
        while (current != null) {
            if (index-- == 0) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < size;
    }
}
