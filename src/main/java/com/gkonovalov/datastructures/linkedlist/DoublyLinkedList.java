package com.gkonovalov.datastructures.linkedlist;


import com.gkonovalov.datastructures.etc.DoubleListNode;
import java.util.Objects;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Doubly Linked List implementation.
 * <p>
 * Runtime Complexity: O(1) for the {@code add}, {@code prepend}, {@code append},
 *                                  {@code size}, {@code removeFirst} and {@code removeLast},
 *                     O(n) for the {@code get}, {@code add}, {@code indexOf}, 
 *                                  {@code contains}, {@code findNode}, and {@code remove}.
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

        DoubleListNode<T> currentNode = findNode(position);

        if (currentNode != null) {
            return currentNode.value;
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

        DoubleListNode<T> currentNode = findNode(position - 1);

        if (currentNode != null) {
            currentNode.next.prev = currentNode.prev;
            currentNode.prev.next = currentNode.next;
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
