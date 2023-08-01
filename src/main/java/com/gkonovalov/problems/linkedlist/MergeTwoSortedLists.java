package com.gkonovalov.problems.linkedlist;


import com.gkonovalov.problems.utils.ListNode;

/**
 * Created by Georgiy Konovalov on 1/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">
 *          [Easy][21] - Merge Two Sorted Lists
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code hasCycle}.
 * Space Complexity:   O(1) for {@code hasCycle}.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(5);

        mergeTwoLists(listNode, listNode2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumb = new ListNode(-1);
        ListNode curr = dumb;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 != null ? list1 : list2;

        return dumb.next;
    }
}
