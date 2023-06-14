package com.gkonovalov.algorithms.linkedlist;


import com.gkonovalov.datastructures.etc.Node;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
 * Floyd's cycle detection algorithm, also known as the "tortoise and hare algorithm",
 * is a cycle-finding algorithm that can be used to detect cycles in a Linked List or any
 * other data structure that can be traversed sequentially.
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity:   O(1).
 */
public class FloydCycleDetection {

    public boolean detectCycle(Node<Integer> node) {
        if (node == null) {
            return false;
        }

        Node<Integer> slow = node;
        Node<Integer> fast = node.getNext();

        while (fast != null && fast.getNext() != null) {
            if (fast == slow) {
                return true;
            }

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return false;
    }

    public boolean detectCycle2(Node<Integer> node) {
        Node<Integer> slow = node;
        Node<Integer> fast = node;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
