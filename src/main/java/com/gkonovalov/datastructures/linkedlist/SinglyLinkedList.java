package com.gkonovalov.datastructures.linkedlist;

import com.gkonovalov.datastructures.etc.Node;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Singly Linked List implementation.
 * <p>
 * Runtime Complexity: O(1) for the {@code add}, {@code size}, {@code prepend}..
 *                     O(n) for the {@code get}, {@code indexOfs}, {@code contains};
 *                     {@code remove} and {@code append}.
 * Space Complexity: O(n)
 */
public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
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

        Node<T> prevNode = findNode(position - 1);
        if (prevNode != null) {
            Node<T> newNode = new Node<>(value);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
            size++;
        }
    }

    public T get(int position) {
        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        Node<T> currentNode = findNode(position);

        if (currentNode != null) {
            return currentNode.getValue();
        }
        return null;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        if (isEmpty()) {
            return -1;
        }

        int index = 0;

        Node<T> current = head;
        while (current != null) {
            if (value == null ?
                    current.getValue() == null :
                    value.equals(current.getValue())) {
                return index;
            }

            index++;
            current = current.getNext();
        }
        return -1;
    }

    public boolean remove(int position) {
        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        if (isEmpty()) {
            return false;
        }

        if (position == 0) {
            head = head.getNext();
            size--;
            return true;
        }

        Node<T> currentNode = findNode(position - 1);

        if (currentNode != null && currentNode.getNext() != null) {
            currentNode.setNext(currentNode.getNext().getNext());
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

        Node<T> newNode = new Node<>(value);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    private void prepend(T value) {
        Node<T> newNode = new Node<>(value);

        if (head != null) {
            newNode.setNext(head);
        }

        head = newNode;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    private Node<T> findNode(int index) {
        if (isEmpty()) {
            return null;
        }

        Node<T> current = head;
        while (current != null) {
            if (index-- == 0) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < size;
    }
}
