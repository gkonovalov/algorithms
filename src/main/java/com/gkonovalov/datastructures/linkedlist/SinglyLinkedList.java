package com.gkonovalov.datastructures.linkedlist;

import java.util.Objects;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Singly Linked List implementation.
 * A linked list is a linear data structure in which elements are stored as individual nodes,
 * where each node contains a value and a reference (or link) to the next node in the sequence.
 * Unlike arrays, linked lists do not require contiguous memory allocation, allowing for efficient
 * insertion and deletion operations. In a singly linked list, each node has a reference only to the
 * next node in the list. The last node in the list points to null, indicating the end of the list.
 * Traversing a singly linked list involves starting from the head (the first node) and following
 * the next references until reaching the end.
 * Linked lists are dynamic data structures, meaning they can grow or shrink in size during program
 * execution. They are commonly used when the number of elements is unknown or can change frequently,
 * or when efficient insertion and deletion operations are required. However, linked lists have slower
 * access times compared to arrays since accessing an element requires traversing the list from
 * the beginning.
 * <p>
 * Runtime Complexity: O(1) for the {@code add}, {@code size}, {@code prepend}, {@code append},
 *                     O(n) for the {@code get}, {@code indexOfs}, {@code contains}, {@code remove}.
 * Space Complexity: O(n).
 */
public class SinglyLinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
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

        ListNode<T> prevNode = findNode(position - 1);
        if (prevNode != null) {
            ListNode<T> newNode = new ListNode<>(value);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    public T get(int position) {
        if (isEmpty()) {
            throw new IllegalStateException("Linked List is empty!");
        }

        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        ListNode<T> current = findNode(position);

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
            throw new IllegalStateException("Linked List is empty!");
        }

        int index = 0;

        ListNode<T> current = head;
        while (current != null) {
            if (Objects.equals(value, current.value)) {
                return index;
            }

            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean remove(int position) {
        if (isEmpty()) {
            throw new IllegalStateException("Linked List is empty!");
        }

        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        if (position == 0) {
            head = head.next;
            size--;
            return true;
        }

        ListNode<T> current = findNode(position - 1);

        if (current != null && current.next != null) {
            current.next = current.next.next;
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
        if (isEmpty()) {
            prepend(value);
            return;
        }

        ListNode<T> newNode = new ListNode<>(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    private void prepend(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (head != null) {
            newNode.next = head;
        }

        head = newNode;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    private ListNode<T> findNode(int index) {
        if (isEmpty()) {
            return null;
        }

        ListNode<T> current = head;
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
