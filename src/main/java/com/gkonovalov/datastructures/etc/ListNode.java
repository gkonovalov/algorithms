package com.gkonovalov.datastructures.etc;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Base block for construction Stack and Linked List.
 * </p>
 */
public class ListNode<T> {
    public T value;
    public ListNode<T> next;

    public ListNode(){}

    public ListNode(T value) {
        this.value = value;
    }
}
