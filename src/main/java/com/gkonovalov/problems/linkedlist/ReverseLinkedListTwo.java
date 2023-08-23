package com.gkonovalov.problems.linkedlist;


import com.gkonovalov.problems.utils.ListNode;

/**
 * Created by Georgiy Konovalov on 22/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">
 *          [Medium][92] - Reverse Linked List II
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code reverseBetween}.
 * Space Complexity:   O(1) for {@code reverseBetween}.
 */
public class ReverseLinkedListTwo {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        reverseBetween(node, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            swap(prev, curr.next);
            swap(prev, curr);
        }

        return dummy.next;
    }

    private static void swap(ListNode a, ListNode b) {
        ListNode tmp = a.next;
        a.next = b.next;
        b.next = tmp;
    }
}
