package com.gkonovalov.problems.linkedlist.reversal;


import com.gkonovalov.problems.utils.ListNode;

/**
 * Created by Georgiy Konovalov on 20/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">
 *              [Easy][206] - Reverse Linked List
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code reverseList}.
 * Space Complexity:   O(1) for {@code reverseList}.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);

        reverseList(node);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;

        return current;
    }

    public static ListNode reverseList3(ListNode head) {
        return reverse(head, null);
    }

    private static ListNode reverse(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }

        ListNode next = curr.next;
        curr.next = prev;

        return reverse(next, curr);
    }
}
