package com.gkonovalov.datastructures.etc;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Base block for construction Doubly Linked List.
 * </p>
 */
public class DoubleListNode<T> {
    public T value;
    public DoubleListNode<T> next;
    public DoubleListNode<T> prev;

    public DoubleListNode() {}

    public DoubleListNode(T value) {
        this.value = value;
    }
}

