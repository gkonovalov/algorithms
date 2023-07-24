package com.gkonovalov.problems.linkedlist;


import com.gkonovalov.problems.utils.ListNode;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">
 *          [Easy][141] - Linked List Cycle
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code hasCycle}.
 * Space Complexity:   O(1) for {@code hasCycle}.
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = listNode;

        System.out.println(hasCycle(listNode));
    }

    public static boolean hasCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
