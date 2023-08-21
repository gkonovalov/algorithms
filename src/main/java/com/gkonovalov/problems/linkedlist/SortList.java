package com.gkonovalov.problems.linkedlist;

import com.gkonovalov.problems.utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Georgiy Konovalov on 21/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">
 *          [Easy][148] - Sort List
 *      </a>
 * </p>
 * Runtime Complexity: O(n log n) for {@code sortList}.
 * Space Complexity:   O(log n) for {@code sortList}.
 */
public class SortList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = listNode;

        sortList(listNode);
    }

    public static ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middle);

        return mergeHalves(left, right);
    }

    private static ListNode mergeHalves(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = left != null ? left : right;

        return dummy.next;
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }

    public static ListNode sortList2(ListNode head) {
        ArrayList<Integer> nodes = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(nodes);

        curr = head;
        for (int num : nodes) {
            curr.val = num;
            curr = curr.next;
        }

        return head;
    }
}
