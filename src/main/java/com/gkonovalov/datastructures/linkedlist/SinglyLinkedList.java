package com.gkonovalov.datastructures.linkedlist;

import com.gkonovalov.datastructures.etc.ListNode;
import java.util.Objects;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Singly Linked List implementation.
 * <p>
 * Runtime Complexity: O(1) for the {@code add}, {@code size}, {@code prepend},
 *                     O(n) for the {@code get}, {@code indexOfs}, {@code contains},
 *                                  {@code remove} and {@code append}.
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

        ListNode<T> prevListNode = findNode(position - 1);
        if (prevListNode != null) {
            ListNode<T> newListNode = new ListNode<>(value);
            newListNode.next = prevListNode.next;
            prevListNode.next = newListNode;
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

        ListNode<T> currentListNode = findNode(position);

        if (currentListNode != null) {
            return currentListNode.value;
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

        ListNode<T> currentListNode = findNode(position - 1);

        if (currentListNode != null && currentListNode.next != null) {
            currentListNode.next = currentListNode.next.next;
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

        ListNode<T> newListNode = new ListNode<>(value);
        tail.next = newListNode;
        tail = newListNode;
        size++;
    }

    private void prepend(T value) {
        ListNode<T> newListNode = new ListNode<>(value);

        if (head != null) {
            newListNode.next = head;
        }

        head = newListNode;

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
