package com.gkonovalov.problems.tree.heap;

import com.gkonovalov.problems.utils.ListNode;

import java.util.PriorityQueue;

/**
 * Created by Georgiy Konovalov on 24/07/2023.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">
 *          [Hard][23] - Merge k Sorted Lists
 *      </a>
 * </p>
 * Runtime Complexity: O(n log n) for {@code mergeKLists}.
 * Space Complexity:   O(n) for {@code mergeKLists}.
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(7);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode[] arr = new ListNode[]{listNode};

        mergeKLists(arr);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;
        while (!minHeap.isEmpty()) {
            ListNode list = minHeap.poll();

            if (list.next != null) {
                minHeap.add(list.next);
            }

            current.next = list;
            current = current.next;
        }

        return result.next;
    }
}
