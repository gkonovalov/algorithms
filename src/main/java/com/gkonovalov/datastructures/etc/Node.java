package com.gkonovalov.datastructures.etc;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Base block for construction Stack and Linked List.
 * </p>
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
