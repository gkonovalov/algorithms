package com.gkonovalov.datastructures.stack;

import com.gkonovalov.datastructures.etc.Node;

/**
 * Created by Georgiy Konovalov on 17/05/2023.
 * <p>
 * Stack implementation using Linked List. Stack is LIFO(Last in First Out) data structure.
 * </p>
 * Runtime Complexity: O(1) for {@code peek}, {@code pop}, {@code push}, {@code isEmpty}.
 * Space Complexity:   O(n).
 */
public class Stack<T> {

    private Node<T> root;
    private int size;

    public Stack() {
        this.size = 0;
    }

    public T peek() {
        if (!isEmpty()) {
            return root.getValue();
        }
        return null;
    }

    public T pop() {
        if (!isEmpty()) {
            size--;

            T val = root.getValue();
            root = root.getNext();
            return val;
        }

        return null;
    }

    public void push(T val) {
        size++;

        Node<T> newNode = new Node<>(val);
        newNode.setNext(root);
        root = newNode;
    }

    public boolean isEmpty() {
        return root == null && size == 0;
    }

    public int size() {
        return size;
    }
}
