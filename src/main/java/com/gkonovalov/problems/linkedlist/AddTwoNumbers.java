package com.gkonovalov.problems.linkedlist;


import com.gkonovalov.problems.utils.ListNode;

/**
 * Created by Georgiy Konovalov on 30/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">
 *          [Medium][2] - Add Two Numbers
 *      </a>
 * </p>
 * Runtime Complexity: O(max(m,n)) for {@code addTwoNumbers}.
 * Space Complexity:   O(1) for {@code addTwoNumbers}.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(4);

        addTwoNumbers(listNode, listNode2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode(sum % 10);
            sum = sum / 10;
            curr = curr.next;
        }

        if (sum > 0) {
            curr.next = new ListNode(sum);
        }
        return result.next;
    }
}
