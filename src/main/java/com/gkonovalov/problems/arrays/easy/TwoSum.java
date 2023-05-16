package com.gkonovalov.problems.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Georgiy Konovalov on 15/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/two-sum/">
 *          [Easy][1] - Two Sum
 *      </a>
 * </p>
 * Runtime Complexity: O(n) for {@code twoSum};
 *                    O(n log n) for {@code twoSum2};
 *                    O(n^2) for {@code twoSum3}.
 * Space Complexity:  O(n) for {@code twoSum}, {@code twoSum2}, @code twoSum3}.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};

        System.out.println("Find duplicate:" + Arrays.toString(twoSum(arr, 3)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (cache.containsKey(complement)) {
                return new int[]{i, cache.get(complement)};
            }

            cache.put(nums[i], i);
        }

        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[]{nums[i], i};
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        int first = 0;
        int last = arr.length - 1;

        while (first < last) {
            int sum = arr[first][0] + arr[last][0];

            if (sum < target) {
                first++;
            } else if (sum > target) {
                last--;
            } else {
                return new int[]{arr[first][1], arr[last][1]};
            }
        }
        return new int[0];
    }

    public static int[] twoSum3(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[i] + nums[k] == target) {
                    return new int[]{i, k};
                }
            }
        }
        return new int[0];
    }

}
