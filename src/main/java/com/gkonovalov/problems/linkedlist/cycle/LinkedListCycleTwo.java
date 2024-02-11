package com.gkonovalov.problems.linkedlist.cycle;

import com.gkonovalov.problems.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Georgiy Konovalov on 21/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/">
 *          [Medium][142] - Linked List Cycle II
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code detectCycle}.
 * Space Complexity:   O(1) for {@code detectCycle}.
 */
public class LinkedListCycleTwo {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = listNode;

        detectCycle(listNode);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
