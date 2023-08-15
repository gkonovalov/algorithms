package com.gkonovalov.problems.arrays.selection;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Georgiy Konovalov on 14/08/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">
 *          [Medium][215] - Kth Largest Element in an Array
 *      </a>
 * </p>
 * Runtime Complexity: O(n) average, (n^2) worst case for {@code findKthLargest},
 *                     O(n log n) for {@code findKthLargest2}.
 * Space Complexity:   O(1) for {@code findKthLargest},
 *                     O(1) for {@code findKthLargest2}.
 */
public class KthLargestElementArray {

    public static void main(String[] args) {
        System.out.println("Kth largest element:" + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k);
    }

    private static int quickSelect(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - k;

        while (start < end) {
            int pivotIndex = partition(nums, start, end);

            if (pivotIndex > index) {
                end = pivotIndex - 1;
            } else {
                start = pivotIndex;
            }
        }

        return nums[start];
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[ThreadLocalRandom.current().nextInt(start, end + 1)];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start >= end) {
                break;
            }

            swap(arr, start++, end--);
        }

        return start;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
