package com.gkonovalov.problems.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Georgiy Konovalov on 10/04/2023.
 * <p>
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">
 *          [Easy][217] - Contains Duplicate
 *      </a>
 * </p>
 * Runtime Complexity: O(n log n) for {@code containsDuplicate}.
 * Space Complexity:  O(1) for {@code containsDuplicate}.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};

        System.out.println("Contains duplicate:" + containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
