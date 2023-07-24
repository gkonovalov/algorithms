package com.gkonovalov.problems.linkedlist;


import com.gkonovalov.problems.utils.ListNode;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">
 *          [Medium][19] - Remove Nth Node From End of List
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code removeNthFromEnd}.
 * Space Complexity:   O(1) for {@code removeNthFromEnd}.
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        System.out.println(removeNthFromEnd(list, 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        count -= n;
        curr = dummy;

        while (count > 0) {
            count--;
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return dummy.next;
    }
}
