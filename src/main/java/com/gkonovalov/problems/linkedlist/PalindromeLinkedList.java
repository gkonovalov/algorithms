package com.gkonovalov.problems.linkedlist;


import com.gkonovalov.problems.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgiy Konovalov on 20/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/">
 *              [Medium][243] - Palindrome Linked List
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code isPalindrome}.
 * Space Complexity:   O(1) for {@code isPalindrome}.
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);

        System.out.println("Is Palindrome:" + isPalindrome(node));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow;
        ListNode curr = slow.next;
        prev.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode start = head;
        ListNode end = prev;

        while (end != null) {
            if (start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.next;
        }

        return true;
    }

    private static boolean isPalindrome;

    public static boolean isPalindrome2(ListNode head) {
        isPalindrome = true;
        helper(head, head);
        return isPalindrome;
    }

    private static ListNode helper(ListNode start, ListNode end) {
        if (end == null) {
            return start;
        }

        ListNode head = helper(start, end.next);

        if (head.val != end.val) {
            isPalindrome = false;
        }

        return head.next;
    }

    public static boolean isPalindrome3(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            if (list.get(start++) != list.get(end--)) {
                return false;
            }
        }
        return true;
    }
}
