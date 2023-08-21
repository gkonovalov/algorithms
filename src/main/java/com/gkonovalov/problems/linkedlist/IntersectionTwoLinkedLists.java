package com.gkonovalov.problems.linkedlist;


import com.gkonovalov.problems.utils.ListNode;

import java.util.HashSet;

/**
 * Created by Georgiy Konovalov on 21/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">
 *          [Easy][160] - Intersection of Two Linked Lists
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code getIntersectionNode}.
 * Space Complexity:   O(1) for {@code getIntersectionNode}.
 */
public class IntersectionTwoLinkedLists {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);

        ListNode node2 = new ListNode(1);
        node2.next = node;

        getIntersectionNode(node, node2);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }

        return a;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode curr = headB;
            while (curr != null) {
                if (headA == curr) {
                    return headA;
                }
                curr = curr.next;
            }
            headA = headA.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
