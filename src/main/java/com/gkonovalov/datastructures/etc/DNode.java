package com.gkonovalov.datastructures.etc;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Base block for construction Doubly Linked List.
 * </p>
 */
public class DNode<T> {
    private T value;
    private DNode<T> next;
    private DNode<T> prev;

    public DNode() {
    }

    public DNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DNode<T> getNext() {
        return next;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public DNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }
}

