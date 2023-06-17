package com.gkonovalov.datastructures.stack;

import com.gkonovalov.datastructures.linkedlist.ListNode;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Stack implementation using Linked List. Stack is LIFO(Last in First Out) data structure.
 * </p>
 * Runtime Complexity: O(1) for {@code peek}, {@code pop}, {@code push}, {@code isEmpty}.
 * Space Complexity:   O(n).
 */
public class Stack<T> {

    private ListNode<T> root;
    private int size;

    public Stack() {
        this.size = 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }

        return root.value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }

        size--;

        T val = root.value;
        root = root.next;
        return val;
    }

    public void push(T val) {
        size++;

        ListNode<T> newListNode = new ListNode<>(val);
        newListNode.next = root;
        root = newListNode;
    }

    public boolean isEmpty() {
        return root == null && size == 0;
    }

    public int size() {
        return size;
    }
}
