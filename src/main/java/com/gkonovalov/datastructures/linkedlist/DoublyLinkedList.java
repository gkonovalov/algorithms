package com.gkonovalov.datastructures.linkedlist;


import com.gkonovalov.datastructures.etc.DNode;

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

    private DNode<T> head;
    private DNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;

        this.head = new DNode<>();
        this.tail = new DNode<>();

        this.head.setNext(tail);
        this.tail.setPrev(head);
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

        DNode<T> prevNode = findNode(position - 1);
        if (prevNode != null) {
            DNode<T> newNode = new DNode<>(value);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
            size++;
        }
    }

    public T get(int position) {
        if (!isIndexValid(position)) {
            throw new IllegalArgumentException("Invalid position!");
        }

        DNode<T> currentNode = findNode(position);

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

        DNode<T> current = head.getNext();

        if (value == null) {
            while (current != null) {
                if (current.getValue() == null){
                    return index;
                }

                index++;
                current = current.getNext();
            }
        } else {
            while (current != null) {
                if (value.equals(current.getValue())){
                    return index;
                }

                index++;
                current = current.getNext();
            }
        }
        return -1;
    }

    public boolean removeFirst() {
        if (size <= 0) {
            return false;
        }

        head.getNext().getNext().setPrev(head);
        head.setNext(head.getNext().getNext());

        size--;
        return true;
    }

    public boolean removeLast() {
        if (size <= 0) {
            return false;
        }

        tail.getPrev().getPrev().setNext(tail);
        tail.setPrev(tail.getPrev().getPrev());

        size--;
        return true;
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

        DNode<T> currentNode = findNode(position - 1);

        if (currentNode != null) {
            currentNode.getNext().setPrev(currentNode.getPrev());
            currentNode.getPrev().setNext(currentNode.getNext());
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
        DNode<T> newNode = new DNode<>(value);
        newNode.setPrev(tail.getPrev());
        newNode.getPrev().setNext(newNode);
        newNode.setNext(tail);
        tail.setPrev(newNode);
        size++;
    }

    private void prepend(T value) {
        DNode<T> newNode = new DNode<>(value);
        newNode.setNext(head.getNext());
        newNode.getNext().setPrev(newNode);
        newNode.setPrev(head);
        head.setNext(newNode);
        size++;
    }

    private DNode<T> findNode(int index) {
        if (isEmpty()) {
            return null;
        }

        DNode<T> current = head.getNext();
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
