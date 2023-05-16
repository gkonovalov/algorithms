package com.gkonovalov.algorithms.linkedlist;


import com.gkonovalov.datastructures.linkedlist.ListNode;

/**
 * Created by Georgiy Konovalov on 15/05/2023.
 * <p>
 * Floyd's cycle detection algorithm, also known as the "tortoise and hare algorithm",
 * is a cycle-finding algorithm that can be used to detect cycles in a Linked List or any
 * other data structure that can be traversed sequentially.
 * </p>
 * Runtime Complexity: O(n).
 * Space Complexity: O(1).
 */
public class FloydCycleDetection {

    public boolean detectCycle(ListNode node) {
        if (node == null) {
            return false;
        }

        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean detectCycle2(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
